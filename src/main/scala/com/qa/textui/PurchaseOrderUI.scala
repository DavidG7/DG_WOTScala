package com.qa.textui;


import com.qa.connector.SQLConnector
import java.util.Scanner
import org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter
import com.qa.utility.NumberFormatter
import com.qa.connector.MongoConnector
import com.qa.utility.Formatting

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
        if(all == true || employeeID == purchaseOrders(count).employeeID){
      print("  " + purchaseOrders(count).purchaseOrderID)
      print("   |    ")
      print(purchaseOrders(count).supplierID)
      print("     |    ")
      print(purchaseOrders(count).purchaseOrderStatus )
      print("   |    ")
      print(purchaseOrders(count).employeeID)
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