package com.qa.controllertest

import com.qa.entitytest.TestBase
import com.qa.controller.ProdController

/**
 * @author dgordon
 */
class ProdControllerTest extends TestBase{
 
  def getAllProductsTest{
    "Calling getAllProducts()" should "return an array of products that is not null" in
    {
      // Instantiate class and run test
      ProdController.getAllProducts should not be (null)
    }
    "Calling getAllProducts" should "return valid data in elements of productID within array" in
    {
      // Instantiate class and run test
      ProdController.getAllProducts.apply(0).productID should be (1)
    }
  }
  
  
  def getProductByIdTest{
    "Calling getProductById" should "return a product with the specified product id" in 
    {
      ProdController.getProductById(1).productID should be (1)
    }
    
  }
 
  
 
  def getNewStockLevelTest{
    "Calling getNewProductStock" should "return the new stock level for a product" in
    {
      ProdController.getNewProductStock("20") should be 
      (ProdController.getProductById(ProdController.activeProductID).stockLevel-20)
    }
    
    "Calling getNewProductStock" should "return 0 if number of stock to remove is greater than number of current stock" in
    {
      ProdController.getNewProductStock("1000") should be (0)
    }
        
    "Calling getNewProductStock" should "return old stock level if a uncompatible string is entered" in
    {
      ProdController.getNewProductStock("20fg") should be (ProdController.getProductById(ProdController.activeProductID).stockLevel)
    }
  }
  
   getAllProductsTest
   getProductByIdTest
   getNewStockLevelTest
   
  
  
}