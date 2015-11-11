package com.qa.UI

import com.qa.Entities.Product
import com.qa.Utility.Formatting

/**
 * @author dgordon
 */
object ProductUI {
  
  def buildProducts(products:Array[Product]) {
    Formatting.printSpaceSmall
    
    var count = 0;
    
    def buildProduct(product:Product){
  
      if(count < products.size){
        count = count + 1
      Formatting.headings("Product ID: " + product.productID)
      println("Product Name: " + product.productName)
      println("Product Description: " + product.productDescription)
      println("Product Price: " + product.price)
      println("Product Rating: " + product.rating)
      println("Product StockLevel: " + product.stockLevel)
      println("Porousware: " + product.price)
      println("On Sale: " + product.onOffer)
      println("Discontinued: " + product.discontinued)
      println("")
      println("")
      try { 
      buildProduct(products(count))
      } catch {
     case iob: ArrayIndexOutOfBoundsException => 
     case e: Exception => 
   }
     }
    }
    
    buildProduct(products(0))
  }
}