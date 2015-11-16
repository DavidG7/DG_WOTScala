package com.qa.controller

import com.qa.connector.MongoConnector
import com.qa.entity.Product
import com.qa.view.ProductView

/**Uses Product model to update ProductView.scala**/
object ProdController {
    
  
  val mongo = new MongoConnector
  
  /** Set initially to 1**/
  var activeProductID = 1

  /**Interact with model (MongoConnector instance) to get all Products*/
  def getAllProducts:Array[Product] = {
    mongo.getMongoData(new Product)
  }
  
  
  def getProductById(productID:Int): Product = {
    val allProducts = mongo.getMongoData(new Product)
    val count = 0
    
    def checkProduct(count:Int): Product = {
      try{
        if(allProducts(count).productID == productID){
          allProducts(count)
        }else{
          checkProduct(count.+(1))
        }
      } catch {
     case e: Exception => allProducts(0)
   }
    }
    
    checkProduct(0)
  }
  
  def setActiveProductID(productID:Int){
    activeProductID = productID
    refreshProductView()
 }
  
  def removeStock(numOfStockToRemove:String){
    mongo.updateProductStock(activeProductID, getNewProductStock(numOfStockToRemove))
    ProductView.refreshProductDescription()
  }
  
  
  
  def getNewProductStock(numberOfStockToRemove:String): Double = {
    try{
     if(getProductById(activeProductID).stockLevel - numberOfStockToRemove.toDouble >= 0){
        getProductById(activeProductID).stockLevel - numberOfStockToRemove.toDouble
     }else{
       0.0
     }
    
    }  catch {
      case e: Exception =>  getProductById(activeProductID).stockLevel - 0
    }
  }
  
  def refreshProductView(){
      ProductView.refreshProductDescription()
  }
   
}

