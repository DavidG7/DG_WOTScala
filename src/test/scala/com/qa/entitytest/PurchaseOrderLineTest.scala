package com.qa.entitytest

import com.qa.entity.PurchaseOrderLine

/**
 * @author dgordon
 */
class PuchaseOrderLineTest extends TestBase{
  
  def purchaseOrderLineTest{
     "A PurchaseOrderLine Entity" should " be initialised with all the correct values" in
    {
      val pOLine = new PurchaseOrderLine(1,4,600)
      pOLine.purchaseOrderLineID should be (1)
      pOLine.productID should be (4)
      pOLine.quantity should be (600)
    }
    
  }
  
  purchaseOrderLineTest
}