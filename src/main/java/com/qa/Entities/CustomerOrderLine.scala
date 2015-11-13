package com.qa.Entities

/**
 * @author dgordon
 */
/** Customer Order Line Entity**/
class CustomerOrderLine(customerOrderID:Int, productID:Int, quantity :Int) {
  
  def getCustomerOrderID() :Int = {
    customerOrderID
  }
  
  def getProductID() :Int = {
    productID
  }
   
  def getQuantity() :Int = {
    quantity
  }
}