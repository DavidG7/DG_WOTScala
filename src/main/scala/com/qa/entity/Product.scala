package com.qa.entity

import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.StringProperty

/**
 * @author dgordon

 */
/** Product Entity**/
class Product(val productID:Double, val productName:String, val productDescription:String, val category:String, 
   val price:Double,val rating:String,val stockLevel:Double,val porousware:Boolean, val discontinued:Boolean, val onOffer:Boolean){

    /** Empty constructor used when defining which generic type to use **/
  def this() = this(0.0,null,null,null,0.0,null,0.0,false,false,false)
  
     /**TableView compatible Object and String properties**/
    val productID_ = new ObjectProperty(this, "productID_", productID)
    val productName_ = new StringProperty(this, "productName_", productName)


}