package com.qa.Utility

/**
 * @author dgordon
 */
class PrevNextEnum extends Enumeration {

 lazy val prevOf = {
   val list = values.toList
   val map = list.tail.zip(list.map(Some(_))).toMap + (list.head -> None)
   map
 }
 lazy val nextOf = {
  val list = values.toList
  val map = (list.zip(list.tail.map(Some(_)) :+ None).toMap)
  map
 }
}

object State extends PrevNextEnum {
 type State = Value
 val Confirmed = Value("Confirmed")
 val Accepted = Value("Accepted ")
 val Picked = Value("Picked   ")
 val Packed = Value("Packed   ")
 val InGDZ = Value("InGDZ    ")
}
