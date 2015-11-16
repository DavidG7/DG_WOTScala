package com.qa.textui;

import com.qa.utility.Formatting
import com.qa.connector.MongoConnector
import java.util.Scanner
import org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter
import com.qa.utility.NumberFormatter


/**
 * @author dgordon
 */
/** Menu UI Terminal **/
object Menu {
  
  val scan  = new Scanner(System.in)//User Input
   
  def buildMenu(mongo:MongoConnector){
    Formatting.printSpacesLarge()
    val employees = mongo.employeeMongoData()
    println("Welcome " + employees(0).employeeName)
    println()
    println("(1) Customer Orders ")
    println("(2) Purchase Orders ")
    println("(3) View my Customer Orders")
    println("(4) Remove Damaged Stock")
    val choice = scan.nextLine()
    val numFormatter = new NumberFormatter
    if(numFormatter.isInteger(choice)){
      val choiceInt = choice.toInt
      menuBridge(choiceInt)
    }else{
      Menu.buildMenu(mongo)
    }
  
    
    
    /**Depending on user input, UI will instantiate different Obeject, CustomerOrder Screen, 
     * PurchaseOrder Screen etc
     */
    def menuBridge(menuChoice:Int) {

    menuChoice match {
      case 1 => CustomerOrderUI.buildCustomerOrderUI(1, true, mongo)
       case 2 => PurchaseOrderUI.buildPurchaseOrderUI(1, true, mongo)
      case 3  => CustomerOrderUI.buildCustomerOrderUI(1, false, mongo)
      case 4  => ProductUI.buildProducts(mongo.productMongoData(),true,mongo)
      case _  =>  Menu.buildMenu(mongo)
    }
  }
}
}