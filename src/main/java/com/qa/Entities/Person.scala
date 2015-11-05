package com.qa.Entities

import scalafx.scene.paint.Color
import scalafx.beans.property.StringProperty
import scalafx.beans.property.ObjectProperty

/**
 * @author dgordon
 */
class Person(firstName_ : String, 
             lastName_ : String, 
             favoriteColor_ : Color) {
  
  val firstName = new StringProperty(this, "firstName", firstName_)
  val lastName = new StringProperty(this, "lastName", lastName_)
  val favoriteColor = new ObjectProperty(this, "favoriteColor", 
                                         favoriteColor_)
}