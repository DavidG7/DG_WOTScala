package com.qa.view

/**
 * @author dgordon
 */
case class TableColumnNames(customerOrderCols:Array[String],purchaseOrderCols:Array[String]) {

  object TableColumnNames {
    val customerOrderCols = ("Customer Order ID", "Customer ID", "Order Status", "Employee ID");
    val purchaseOrderCols = ("Purchase Order ID", "Customer ID", "Order Status", "Employee ID");
  }
  
}