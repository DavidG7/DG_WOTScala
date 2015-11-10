package com.qa.Connectors

import java.util.Scanner
import java.io.Console
import com.qa.Entities.Employee
import com.qa.Utility.NumberFormatter
import com.qa.Utility.NumberFormatter
import com.qa.Utility.State
import com.qa.UI.Gnome
import com.sun.javafx.scene.control.skin.ButtonBarSkin.Spacer
import com.qa.Utility.Formatting
import com.qa.Utility.Help
import scala.collection.mutable.Stack

/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
   
   val mongo = new MongoConnector
   val employees = mongo.employeeMongoData()
   Gnome.printGnome()
   val sqlConnector = new SQLConnector
   val customerOrders = sqlConnector.getCustomerOrderTableInfo()
   val customerOrderLines = sqlConnector.getCustomerOrderLineTableInfo()
   val scan  = new Scanner(System.in)
   val numFormatter = new NumberFormatter
   
   

   
  def main(args: Array[String]){
   //  (buildLanding(true))::methodFlow
      //buildLanding(true)
     val methodFlow = List[Any](buildLanding(true), loginBridge(validate ("JS117","Gnomes4LIFE!")))
  }
  
  def buildLanding(firstTime:Boolean):Any = {
    if(firstTime){
      println()
      println()
      println("WELCOME TO NBGARDENS WAREHOUSE ORDER TRACKING SYSTEM")
      println()
      println("Please Login")
    }else{
      println("")
      println("Ensure correct credintials before retrying")
    }
    println("Username:")
    
    val username = scan.nextLine()
    println("Password:")
    val password = scan.nextLine()
   // loginBridge(validate (username,password))
    
    //methodFlow.push(loginBridge(validate (username,password)))
 }
  
  def validate(username:String, password:String):Boolean = {
    
    val count = 0
  
    
    def validateIndividual(employee:Employee):Boolean = {
     
      if(employee.getEmployeeUserName().equals(username)&& employee.getEmployeePassword().equals(password)){
        true
      }else{      
        if(count < employees.size && employees.size >1){
          println(count)
          validateIndividual(employees(count.+(1)))
        }
        false
      }
        
    }
    
    validateIndividual(employees(0))
  }
  
  
  def loginBridge(validated:Boolean) {

    validated match {
      case true  => menu()
      case false  => buildLanding(false) 
      case _  =>  
    }
  }
  
  
  def menu(){
    Formatting.printSpacesLarge()
    println("Welcome " + employees(0).getEmployeeName())
    println()
    println("(1) Customer Orders ")
     println("(2) View my Orders")
    val orderType = scan.nextLine()
    orderBridge(menu,orderType)
    //println("Welcome" + employees(0).getEmployeeName())
    
  }
  
  def orderBridge(callback: () => Unit,orderType:String): Unit = { 
    /*val numFormatter = new NumberFormatter
    if(numFormatter.convertFromStringToInt(orderType)){
      val orderTypeInt = orderType.toInt
      orderTypeInt match {
      case 1 => customerOrder()
      
      case 2 => customerOrder(1,false)
   
      case _  => callback() 
    }
    }else{
      callback()
    }*/
    //methodFlow.init
    //println(methodFlow.size)
   
    
  }
  
  
  def customerOrder(employeeID:Int = 0, all:Boolean = true) = {
    Formatting.printSpacesLarge()
    Formatting.headings("Customer Orders")
    val count = 0
      print("CO ID ")
      print("|   ")
      print("CU ID")
      print("   |    ")
      print("CO STATUS")
       print("   | ")
        print("EMP ID")
       print(" |")
      println()
    
    def printCustomerOrder(count:Int):Unit= {
      try{
        if(all == true || employeeID == customerOrders(count).getEmoployeeID()){
      print("  " + customerOrders(count).getCustomerOrderID())
      print("   |    ")
      print(customerOrders(count).getCustomerID())
      print("    |    ")
      print(customerOrders(count).customerOrderStatus )
      print("   |    ")
      print(customerOrders(count).getEmoployeeID())
      print("   |")
      println()
      printCustomerOrder(count.+(1))
        }
      }catch {
      case e: IndexOutOfBoundsException => ()    }
    }
    
    //println(State.prevOf(State.Accepted).toString())
      printCustomerOrder(count)
      val orderType = scan.nextLine()
    
      if(numFormatter.convertFromStringToInt(orderType)){
      customerOrderLine(orderType.toInt)
      
      }else{
        Help.help()
      }
     
  }
  
  
  def customerOrderLine(coID:Int):Unit = {
    Formatting.printSpacesLarge()
    Formatting.headings("Customer Orders Lines for Customer Order " + coID)
    val count = 0
      print("CO ID ")
      print("|   ")
      print("P ID")
      print("  |  ")
      print("QUAN")
       print("  |")
      println()
    
    def printCustomerOrderLines(count:Int):Unit= {
    
      try{
      if(coID == customerOrderLines(count).getCustomerOrderID()){
      print("  " + customerOrderLines(count).getCustomerOrderID())
      print("   |    ")
      print(customerOrderLines(count).getProductID())
      print("    |    ")
      print(customerOrderLines(count).getQuantity() )
       print("   |")
      println()
      printCustomerOrderLines(count.+(1))
      }else{
        printCustomerOrderLines(count.+(1))
      }
      }catch {
      case e: IndexOutOfBoundsException => ()    }
      
    }
    
    //println(State.prevOf(State.Accepted).toString())
  
      
      printCustomerOrderLines(count)
      println("")
      println("(1) Check Out Order")
      val orderType = scan.nextLine()
      val state = State.nextOf(State.withName(State.Confirmed.toString))
     if(numFormatter.convertFromStringToInt(orderType)){
       sqlConnector.updateCustomerOrderTable(coID,State.Confirmed.toString(),employees(0).getEmployeeID())
      // println(State.Confirmed.toString)
      //customerOrderLine(orderType.toInt)
     
     }
      
   

  }
  
  

 

   
    

  
}