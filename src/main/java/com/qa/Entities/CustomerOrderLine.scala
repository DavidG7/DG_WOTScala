package com.qa.Entities

/**
 * @author dgordon
 */
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