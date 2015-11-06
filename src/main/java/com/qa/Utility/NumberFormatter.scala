package com.qa.Utility

/**
 * @author dgordon
 */
class NumberFormatter {
  def convertFromStringToInt(temp:String):Boolean = {
   
   try { 
   val tempInt = temp.toInt
   true
   } catch {
     case ne: NumberFormatException => false
     case e: Exception => false
   }
  
    
  }
}