package com.qa.controller

import com.qa.connector.SQLConnector
import com.qa.entity.CustomerOrder
import com.qa.utility.CustomerOrderState
import com.qa.view.CustomerOrderView
import com.qa.driver.GUIDriver



/**
 * @author dgordon
 */

/**Controller used to manage CustomerOrder Model data and the CustomerOrder View**/
object CustomerOrderController {
  
  val sql = new SQLConnector
  
  var activeOrderID = 0
  var activeStatus = "Confirmed"
  var activeEmployeeID = 0
    
  
  /**Interact with model (SQLConnector instance) to get all customer orders*/
  def getAllCustomerOrders():Array[CustomerOrder] = {
    sql.getCustomerOrderTableInfo()
  }
  
  
  /** Methods called by view to update current customer order**/
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

  
  /** Method updates the active order with the new order status by getting the 
   *  next state from an class inheriting from enumeration
   */
  def updateCustomerOrderStatus(){
    /* Get next Customer Order State using enumeration */
    val state = CustomerOrderState.nextOf(CustomerOrderState.withName(activeStatus)).toString().substring(5,14)
    sql.updateCustomerOrderTable(activeOrderID, state, activeEmployeeID)
    
    /** Using instance of Main UI class to refresh the scene by resetting a new  CustomerOrderView**/
    GUIDriver.stage.scene_=(CustomerOrderView.buildCustomerOrder())
    
  }
  
  
  
  
}