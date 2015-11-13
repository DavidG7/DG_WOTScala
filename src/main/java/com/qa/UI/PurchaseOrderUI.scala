package com.qa.UI

import com.qa.Connectors.SQLConnector
import java.util.Scanner
import org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter
import com.qa.Utility.NumberFormatter
import com.qa.Connectors.MongoConnector
import com.qa.Utility.Formatting

/**
 * @author dgordon
 */
object PurchaseOrderUI {
  var sqlConnector = new SQLConnector
  var purchaseOrders = sqlConnector.getPurchaseOrderTableInfo()
  
  val scan  = new Scanner(System.in)
  val numFormatter = new NumberFormatter
  
  def buildPurchaseOrderUI(employeeID:Int = 0, all:Boolean = true, mongo:MongoConnector): Unit = {
    Formatting.printSpacesLarge()
    Formatting.headings("Purchase Orders")
    val count = 0
      print("PO ID ")
      print("|   ")
      print("S ID")
      print("   |   ")
      print("PO STATUS")
       print("   | ")
        print("EMP ID")
       print(" |")
      println()
    
    def printPurchaseOrder(count:Int):Unit= {
      try{
        if(all == true || employeeID == purchaseOrders(count).getEmployeeID()){
      print("  " + purchaseOrders(count).getPurchaseOrderID())
      print("   |    ")
      print(purchaseOrders(count).getSupplierID())
      print("     |    ")
      print(purchaseOrders(count).getPurchaseOrderStatus() )
      print("   |    ")
      print(purchaseOrders(count).getEmployeeID())
      print("   |")
      println()
      printPurchaseOrder(count.+(1))
        }
      }catch {
      case e: IndexOutOfBoundsException => ()    }
    }
    
    //println(State.prevOf(State.Accepted).toString())
      printPurchaseOrder(count)
      val orderToView = scan.nextLine()
     if(numFormatter.isInteger(orderToView)){
        purchaseOrderBridge(orderToView.toInt)
      }else{
        Menu.buildMenu(mongo)
      }
      
      
      def purchaseOrderBridge(numChosen:Int) {
        numChosen match {
        //case  x if x <= purchaseOrders.size => CustomerOrderLineUI.customerOrderLine(x-1, customerOrderLines,mongo,sqlConnector,employeeID)
        case _  =>  Menu.buildMenu(mongo)
        }
     }
   }
  
  
  def updateDataFromDB(){
    sqlConnector = new SQLConnector
    purchaseOrders = sqlConnector.getPurchaseOrderTableInfo()
  }
}