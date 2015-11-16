package com.qa.textui;


import com.qa.utility.Formatting
import com.qa.entity.CustomerOrder
import java.util.Arrays.ArrayList
import com.qa.connector.SQLConnector
import java.util.Scanner
import com.qa.connector.MongoConnector
import com.qa.utility.NumberFormatter

import com.qa.entity.CustomerOrderLine

/**
 * @author dgordon
 */
object CustomerOrderUI {
  
  var sqlConnector = new SQLConnector
  var customerOrders = sqlConnector.getCustomerOrderTableInfo()
  val customerOrderLines = sqlConnector.getCustomerOrderLineTableInfo()
  val scan  = new Scanner(System.in)
  val numFormatter = new NumberFormatter
  
  def buildCustomerOrderUI(employeeID:Int = 0, all:Boolean = true, mongo:MongoConnector): Unit = {
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
        if(all == true || employeeID == customerOrders(count).employeeID){
      print("  " + customerOrders(count).customerOrderID)
      print("   |    ")
      print(customerOrders(count).customerID)
      print("    |    ")
      print(customerOrders(count).customerOrderStatus )
      print("   |    ")
      print(customerOrders(count).employeeID)
      print("   |")
      println()
      printCustomerOrder(count.+(1))
        }
      }catch {
      case e: IndexOutOfBoundsException => ()    }
    }
    
    //println(State.prevOf(State.Accepted).toString())
      printCustomerOrder(count)
      val orderToView = scan.nextLine()
     if(numFormatter.isInteger(orderToView)){
        customerOrderBridge(orderToView.toInt)
      }else{
        Menu.buildMenu(mongo)
      }
      
      
      def customerOrderBridge(numChosen:Int) {
        numChosen match {
        case  x if x <= customerOrders.size => CustomerOrderLineUI.customerOrderLine(x-1, customerOrderLines,mongo,sqlConnector,employeeID)
        case _  =>  Menu.buildMenu(mongo)
        }
     }
   }
  
  
  def updateDataFromDB(){
    sqlConnector = new SQLConnector
    customerOrders = sqlConnector.getCustomerOrderTableInfo()
  }
}