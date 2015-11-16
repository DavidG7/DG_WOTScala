package com.qa.utility
/**Used in Text based UI**/
/**
 * @author dgordon
 */

/** Utility class to print spaces and headings **/
object Formatting {
  def printSpacesLarge() {
    println()
    println()
    println()
  }

  def printSpaceSmall {
    println()
  }

  /**Tail recursive method that underlines all headings depending on their size**/
  def headings(heading: String) {
    println(heading)
    val headingLength = heading.length()
    val count = 0
    def printUnderLine(temp: Int) {
      if (temp <= headingLength) {
        print("_")
        printUnderLine(temp.+(1))
      }
    }
    printUnderLine(count)
    println("")
    println("")

  }
}