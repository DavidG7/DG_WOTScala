package com.qa.Entities

import scalafx.beans.property.StringProperty

/**
 * @author dgordon
 */
class PurchaseOrder (purchaseOrderID:Int, supplierID:Int, employeeID: Int, purchaseOrderDate:String, purchaseOrderStatus: String) {
  
  val purchaseOrderID_ = new StringProperty(this, "purchaseOrderID_", purchaseOrderID.toString())
  val employeeID_ = new StringProperty(this, "employeeID_", employeeID.toString())
  val purchaseOrderStatus_ = new StringProperty(this, "purchaseOrderStatus_", purchaseOrderStatus.toString())
  
  
  
  def getPurchaseOrderID() :Int = {
    purchaseOrderID
  }
  
  def getSupplierID() : Int = {
    supplierID
  }
   
  def getEmployeeID() :Int = {
    employeeID
  }
    
  def getPurchaseOrderDate() :String = {
    purchaseOrderDate
  }
     
  def getPurchaseOrderStatus() :String = {
    purchaseOrderStatus
  }
  
}