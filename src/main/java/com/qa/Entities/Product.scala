package com.qa.Entities

import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.StringProperty

/**
 * @author dgordon

 */
/** Product Entity**/
class Product(val productID:Double, val productName:String, val productDescription:String, val category:String, 
   val price:Double,val rating:String,val stockLevel:Double,val porousware:Boolean, val discontinued:Boolean, val onOffer:Boolean){

  def this() = this(0.0,null,null,null,0.0,null,0.0,false,false,false)
  
    val productID_ = new ObjectProperty(this, "productID_", productID)
    val productName_ = new StringProperty(this, "productName_", productName)


}