package com.qa.Utility

/**
 * @author dgordon

 */

/**Validates scan.next() as INT*/
class NumberFormatter {
  
  def isInteger(temp:String):Boolean = {
   
   try { 
   val tempInt = temp.toInt
   true
   } catch {
     case ne: NumberFormatException => false
     case e: Exception => false
   }
  
    
  }
}