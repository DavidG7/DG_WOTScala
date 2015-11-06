package com.qa.Connectors

import java.util.Scanner
import java.io.Console
import com.qa.Entities.Employee
import com.qa.Utility.NumberFormatter
import com.qa.Utility.NumberFormatter

/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
   val mongo = new MongoConnector
   val employees = mongo.employeeMongoData()
   val scan  = new Scanner(System.in)
    
  def main(args: Array[String]){
     val sqlConnector = new SQLConnector
     sqlConnector.getTableInfo("customerOrder")
    // buildLanding(true)
  }
  
  def buildLanding(firstTime:Boolean) {
    if(firstTime){
      println("/** Welcome to NBGardens Warehouse Order Tracking System **/")
      println()
      println("Please Login")
    }else{
      println("")
      println("Login Unsuccessfull")
      println("Ensure correct credintials before retrying")
    }
    println("Username:")
    
    val username = scan.nextLine()
    println("Password:")
    val password = scan.nextLine()
    loginBridge(validate (username,password))
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
    println()
    println("Welcome " + employees(0).getEmployeeName())
    println()
    println("/**MENU**/")
    println("(1) Customer Orders ")
    val orderType = scan.nextLine()
    orderBridge(menu,orderType)
    //println("Welcome" + employees(0).getEmployeeName())
    
  }
  
  def orderBridge(callback: () => Unit,orderType:String): Unit = { 
    val numFormatter = new NumberFormatter
    if(numFormatter.convertFromStringToInt(orderType)){
      val orderTypeInt = orderType.toInt
      orderTypeInt match {
      case 1 => customerOrders(menu)
   
      case _  => callback() 
    }
    }else{
      callback()
    }
   
    
  }
  
  
  def customerOrders(callback: () => Unit) = {
    println("Customer Orders")
  }
  

   
    

  
}