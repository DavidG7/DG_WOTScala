
package com.qa.controllertest

import com.qa.controller.CustomerOrderController
import com.qa.entitytest.TestBase


/**
 * @author dgordon
 */
class CustomerOrderControllerTest extends TestBase{
  
  def getAllCustomerOrdersTest{
    "Calling getAllCustomerOrders()" should "return an array of customer orders that is not null" in
    {
      // Instantiate class and run test
      CustomerOrderController.getAllCustomerOrders() should not be (null)
    }
    "Calling getAllCustomerOrders()" should "return valid data in elements of customerOrderID within array" in
    {
      // Instantiate class and run test
      CustomerOrderController.getAllCustomerOrders().apply(0).customerOrderID should be (1)
    }
  }
  
  
   def setActiveOrderIDTest{
    "Calling setActiveOrderID" should "set the active order to the ID given to 'setActiveOrderID'" in
    {
      // Instantiate class and run test
      CustomerOrderController.setActiveOrderID(2) 
      CustomerOrderController.activeOrderID should be (2)
    }
  }
   
  
    
  def setActiveStatusTest{
    "Calling setActiveStatus" should "set the active status to the status given to 'setActiveStatus'" in
    {
      // Instantiate class and run test
      CustomerOrderController.setActiveStatus("Confirmed") 
      CustomerOrderController.activeStatus should be ("Confirmed")
    }
  }
  
  def setActiveEmployeeIDTest{
    "Calling setActiveEmployeeID" should "set the active employee id to the employee id given to 'setActiveEmployeeID'" in
    {
      // Instantiate class and run test
      CustomerOrderController.setActiveStatus("Confirmed") 
      CustomerOrderController.activeStatus should be ("Confirmed")
    }
  }
  // Run tests
  getAllCustomerOrdersTest
  setActiveOrderIDTest
  setActiveStatusTest
  setActiveEmployeeIDTest
}