package com.qa.Entities

/**
 * @author dgordon
 */

/** Customer Order Entity**/
class CustomerOrder (customerOrderID:Int, customerID:Int, customerOrderDate:String, var customerOrderStatus:String, employeeID:Int){
  
   def getCustomerOrderID() :Int = {
    customerOrderID
  }
  
  def getCustomerID() :Int = {
    customerID
  }
   
  def getCustomerOrderDate() :String = {
    customerOrderDate
  }
    
  def getEmoployeeID() :Int = {
    employeeID 
   }


}