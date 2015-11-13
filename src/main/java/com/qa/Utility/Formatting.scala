package com.qa.Utility

/**
 * @author dgordon
 */

/** Utility class to print spaces and headings **/
object Formatting {
  def printSpacesLarge(){
    println()
    println()
    println()
    }
  
  def printSpaceSmall{
     println()
  }
  
  def headings (heading:String){
    println(heading)
    val headingLength = heading.length()
    val count = 0
    def printUnderLine(temp:Int){
      if(temp <= headingLength){
      print("_")
      printUnderLine(temp.+(1))
      }
    }
    printUnderLine(count)
    println("")
    println("")
          
  }
}