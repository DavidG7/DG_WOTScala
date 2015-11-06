package com.qa.Entities

/**
 * @author dgordon
 */
class CustomerOrder (customerOrderID:Int, customerID:Int, customerOrderDate:String, var customerOrderStatus:String, customerOrderTotal:Double){
  
   def getCustomerOrderID() :Int = {
    customerOrderID
  }
  
  def getCustomerID() :Int = {
    customerID
  }
   
  def getCustomerOrderDate() :String = {
    customerOrderDate
  }
    
  def getCustomerOrderTotal() :Double = {
    customerOrderTotal 
   }


}