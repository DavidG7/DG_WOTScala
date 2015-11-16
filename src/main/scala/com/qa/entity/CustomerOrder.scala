package com.qa.entity

import scalafx.beans.property.StringProperty
import scalafx.beans.property.ObjectProperty

/**
 * @author dgordon

 */


/** Class to model Customer Order **/

/** Customer Order Entity**/
class CustomerOrder (val customerOrderID:Int, val customerID:Int, val customerOrderDate:String, val customerOrderStatus:String, val employeeID:Int){
  
  
  
  /**TableView compatible Object and String properties**/
  val customerOrderID_ = new ObjectProperty(this, "customerOrderID_", customerOrderID)
  val customerID_ = new ObjectProperty(this, "customerID_", customerID)
  val customerOrderStatus_ = new StringProperty(this, "customerOrderStatus_", customerOrderStatus)
  val employeeID_ = new ObjectProperty(this, "employeeID_",employeeID)
  
  
  

}