package com.qa.utility

/**
 * @author dgordon

 *
 */

/**Validates scan.next() as INT*/


class NumberFormatter {

  
  /**Returns true if string parameter can be successfully converted to Int, else returns false**/
  def isInteger(temp: String): Boolean = {

    try {
      val tempInt = temp.toInt
      true
    } catch {
      case ne: NumberFormatException => false
      case e: Exception              => false
    }

  }
}