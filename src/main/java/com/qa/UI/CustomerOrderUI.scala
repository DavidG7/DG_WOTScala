package com.qa.UI

import com.qa.Utility.Formatting
import com.qa.Entities.CustomerOrder
import java.util.Arrays.ArrayList
import com.qa.Connectors.SQLConnector
import java.util.Scanner
import com.qa.Connectors.MongoConnector
import com.qa.Utility.NumberFormatter
import com.qa.Utility.Help
import com.qa.Entities.CustomerOrderLine

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
      val orderToView = scan.nextLine()
     if(numFormatter.convertFromStringToInt(orderToView)){
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