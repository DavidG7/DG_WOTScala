package com.qa.utilitytest

import com.qa.entitytest.TestBase
import com.qa.utility.NumberFormatter

/**
 * @author dgordon
 */
class NumberFormatterTest extends TestBase{
  def isIntegerTest(){
    "Calling isInteger" should " Return true if string parameter can be successfully converted to Int" in {
      val numberFormatter = new NumberFormatter
      numberFormatter.isInteger("1") should be (true)
    }
   "Calling isInteger" should " Return false if string parameter cannot be successfully converted to Int" in {
      val numberFormatter = new NumberFormatter
      numberFormatter.isInteger("1ff") should be (false)
    }
  }
  
  isIntegerTest()
}