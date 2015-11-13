package com.qa.UI

import com.qa.Utility.Formatting
import com.qa.Entities.CustomerOrderLine
import com.qa.Utility.NumberFormatter
import java.util.Scanner
import com.qa.Connectors.MongoConnector
import com.qa.Connectors.SQLConnector
import com.qa.Entities.Employee
import java.util.Arrays.ArrayList
import com.qa.Entities.CustomerOrder
import com.qa.Entities.Product
import com.qa.Utility.CustomerOrderState

/**
 * @author dgordon
 */
object CustomerOrderLineUI {
    
  val scan  = new Scanner(System.in)
  val numFormatter = new NumberFormatter

  
  def customerOrderLine(coID:Int, customerOrderLines:Array[CustomerOrderLine], mongo:MongoConnector, 
      sql: SQLConnector,employeeID:Int):Unit = {
    val employees = mongo.getMongoData(new Employee)
    val products = mongo.getMongoData(new Product)
    val customerOrders = sql.getCustomerOrderTableInfo()
    val activeCustomerOrder = customerOrders(coID)
    Formatting.printSpacesLarge()
    Formatting.headings("Customer Orders Lines for Customer Order " + (coID +1))
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
      if(coID  +1== customerOrderLines(count).getCustomerOrderID()){
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
    
   
  
      
      printCustomerOrderLines(count)
      println("")
      println("(1) Check Out Order")
      println("(2) View Products")
      
      println("(3) View Warehouse Tracker for Order")

      val state = CustomerOrderState.nextOf(CustomerOrderState.withName(activeCustomerOrder.customerOrderStatus)).toString().substring(5,14)
      val option = scan.next()
      if(state.equals("Picked   ")){
       
           for( x <- 0 to products.length-1){
            for( y <-0 to customerOrderLines.length-1){
              if(products(x).productID == customerOrderLines(y).getProductID() && 
                  coID +1  == customerOrderLines(y).getCustomerOrderID()){
                  mongo.updateProductStock(products(x).productID.toInt, products(x).stockLevel-customerOrderLines(y).getQuantity())
              }
              }
        }
      }
      
     if(numFormatter.isInteger(option)){

        customerOrderLineBridge(option.toInt)
      }
      
     
      def customerOrderLineBridge(index:Int) {
    
      index match {
      case 1 => sql.updateCustomerOrderTable(coID+1,state,employeeID)
                CustomerOrderUI.updateDataFromDB()
                CustomerOrderUI.buildCustomerOrderUI(employeeID, true, mongo)
                
      case 2  => ProductUI.buildProducts(getActiveProducts(),false,mongo)
      case _  => Menu.buildMenu(mongo)  
    }
   }
      
      
     def getActiveProducts(): Array[Product] = {

           var countTemp = 0
          val temp = new Array[Product](customerOrderLines.length)
          for( x <- 0 to products.length-1){
            for( y <-0 to customerOrderLines.length-1){
              if(products(x).productID == customerOrderLines(y).getProductID() && 
                  coID +1  == customerOrderLines(y).getCustomerOrderID()){
               
                temp(countTemp) = products(x)
                countTemp = countTemp + 1
                
              }
            }
          }
     
           temp
        }
        
      
     
      
  }
  
  
 
  
}