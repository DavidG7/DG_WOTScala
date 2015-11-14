package com.qa.Controller

import com.qa.Connectors.SQLConnector
import com.qa.Entities.CustomerOrder
import com.qa.Utility.CustomerOrderState
import com.qa.View.ViewMain
import com.qa.View.CustomerOrderView

/**
 * @author dgordon
 */


object CustomerOrderController {
  
  val sql = new SQLConnector
  var activeOrderID = 0
  var activeStatus = "Confirmed"
  var activeEmployeeID = 0
    
  
  
  def getAllCustomerOrders():Array[CustomerOrder] = {
    sql.getCustomerOrderTableInfo()
  }
  
  def setActiveOrderID(orderID:Int){
    activeOrderID = orderID
    println(activeOrderID)
  }
  
  def setActiveStatus(status:String){
    activeStatus = status;
      println(activeStatus)
  }
  
  def setActiveEmployeeID(employeeID: Int){
    activeEmployeeID = employeeID;
      println(activeEmployeeID)
  }

  
  def updateCustomerOrderStatus(){
    val state = CustomerOrderState.nextOf(CustomerOrderState.withName(activeStatus)).toString().substring(5,14)
    println(state)
    sql.updateCustomerOrderTable(activeOrderID, state, activeEmployeeID)
    ViewMain.stage.scene_=(CustomerOrderView.buildCustomerOrder())
    
  }
  
  
  
  
}