package com.qa.textui;


import com.qa.entity.Product
import com.qa.utility.Formatting
import java.util.Scanner
import com.qa.connector.MongoConnector

import com.qa.utility.NumberFormatter

/**
 * @author dgordon
 */
object ProductUI {
  
  def buildProducts(products:Array[Product], canRemoveStock:Boolean,mongo:MongoConnector) {
    Formatting.printSpaceSmall
    
    var count = 0;
    val scan  = new Scanner(System.in)
    val numFormatter = new NumberFormatter
    
    def buildProduct(product:Product, doAll:Boolean){
    
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
        if(doAll){
        buildProduct(products(count),true)
        }
      }catch {
        case iob: ArrayIndexOutOfBoundsException => 
        case e: Exception => 
      }
     }
   }
    
    buildProduct(products(0),true)
    if(canRemoveStock){
      count = 0
      println("(#) Select an Order ID")
      println("(Letter) Menu")
     
      val option = scan.next()
      if(numFormatter.isInteger(option)){
          productBridge(option.toInt)
      }else{
         Menu.buildMenu(mongo)
      }
      
     
      println("# Number of Broken Items")
      val numberOfBrokenItems = scan.next()
      mongo.updateProductStock(option.toInt, products(option.toInt-1).stockLevel - numberOfBrokenItems.toDouble)
      
      buildProducts(mongo.productMongoData(), true, mongo)
    }else{
      val returnToMenu = scan.next()
      println("(1) Return to Menu")
      Menu.buildMenu(mongo)
    }
    
   
   
    
     def productBridge(numChosen:Int) {
        
        numChosen match {
        case  x if x <= products.size => buildProduct(products(x-1),false)
        case _  =>  
        }
     }
     
  
  }
  
  
}