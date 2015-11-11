package com.qa.UI

import com.qa.Utility.Formatting
import com.qa.Connectors.MongoConnector
import java.util.Scanner
import org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter
import com.qa.Utility.NumberFormatter

/**
 * @author dgordon
 */
object Menu {
  
  val scan  = new Scanner(System.in)
   
  def buildMenu(mongo:MongoConnector){
    Formatting.printSpacesLarge()
    val employees = mongo.employeeMongoData()
    println("Welcome " + employees(0).getEmployeeName())
    println()
    println("(1) Customer Orders ")
    println("(2) View my Orders")
    val choice = scan.nextLine()
    val numFormatter = new NumberFormatter
    if(numFormatter.convertFromStringToInt(choice)){
      val choiceInt = choice.toInt
      menuBridge(choiceInt)
    }else{
      Menu.buildMenu(mongo)
    }
  
    
    def menuBridge(menuChoice:Int) {

    menuChoice match {
      case 1 => CustomerOrderUI.buildCustomerOrderUI(1, true, mongo)
      case 2  => CustomerOrderUI.buildCustomerOrderUI(1, false, mongo)
      case _  =>  Menu.buildMenu(mongo)
    }
  }
}
}