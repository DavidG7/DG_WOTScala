package com.qa.Entities

/**
 * @author dgordon

 */
/** Purchase Order Line Entity**/
class PurchaseOrderLine (purchaseOrderLineID:Int,productID:Int,var quantity:Int){

  def getPurchaseOrderLineID() :Int = {
    purchaseOrderLineID
  }
   
  def getProductID :Int = {
    productID
  }
    

  
}