package com.qa.Entities

/**
 * @author dgordon

 */
/** Product Entity**/
case class Product(productID:Double, productName:String, productDescription:String, category:String, 
   price:Double,rating:String,stockLevel:Double,porousware:Boolean, discontinued:Boolean, onOffer:Boolean){

  def this() = this(0.0,null,null,null,0.0,null,0.0,false,false,false)
  


}