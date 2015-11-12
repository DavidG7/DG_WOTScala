package com.qa.Entities

import scalafx.beans.property.StringProperty

/**
 * @author dgordon
 */
class PurchaseOrder (purchaseOrderID:Int, supplierID:Int, employeeID: Int, purchaseOrderDate:String, purchaseOrderStatus: String) {
  
 
  
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