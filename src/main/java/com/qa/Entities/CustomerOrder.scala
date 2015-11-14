package com.qa.Entities

import scalafx.beans.property.StringProperty
import scalafx.beans.property.ObjectProperty

/**
 * @author dgordon
 */

/** Customer Order Entity**/
class CustomerOrder (customerOrderID:Int, customerID:Int, customerOrderDate:String, var customerOrderStatus:String, employeeID:Int){
  
  val customerOrderID_ = new ObjectProperty(this, "customerOrderID_", customerOrderID)
  val customerID_ = new ObjectProperty(this, "customerID_", customerID)
  val customerOrderStatus_ = new StringProperty(this, "customerOrderStatus_", customerOrderStatus)
  val employeeID_ = new ObjectProperty(this, "employeeID_",employeeID)
  
  
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