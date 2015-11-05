package com.qa.Entities

/**
 * @author dgordon
 */
class PurchaseOrderLine (purchaseOrderLineID:Int,productID:Int,var quantity:Int){

  def getPurchaseOrderLineID() :Int = {
    purchaseOrderLineID
  }
   
  def getProductID :Int = {
    productID
  }
    

  
}