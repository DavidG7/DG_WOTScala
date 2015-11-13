package com.qa.Utility

/**
 * @author dgordon

 */

/** Stores as ENUM customer order states**/
class PrevNextEnum extends Enumeration {

  /**Gets prev state as State object**/
 lazy val prevOf = {
   val list = values.toList
   val map = list.tail.zip(list.map(Some(_))).toMap + (list.head -> None)
   map
 }
   /**Gets next state as State object**/
 lazy val nextOf = {
  val list = values.toList
  val map = (list.zip(list.tail.map(Some(_)) :+ None).toMap)
  map
 }
}

object CustomerOrderState extends PrevNextEnum {
   type State = Value
   val Confirmed = Value("Confirmed")
   val Accepted = Value("Accepted ")
   val Picked = Value("Picked   ")
   val Packed = Value("Packed   ")
   val InGDZ = Value("InGDZ    ")
}


object PurchaseOrderState extends PrevNextEnum {
   type State = Value
   val Confirmed = Value("Confirmed")
   val Accepted = Value("Accepted ")
   val Picked = Value("Picked   ")
   val Packed = Value("Packed   ")
   val InGDZ = Value("InGDZ    ")
}
