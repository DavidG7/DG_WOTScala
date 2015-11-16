package com.qa.entitytest

import com.qa.entity.PurchaseOrder

/**
 * @author dgordon
 */
class PuchaseOrderTest extends TestBase{
  
  def purchaseOrderTest{
     "A PurchaseOrder Entity" should " be initialised with all the correct values" in
    {
      val pO = new PurchaseOrder(1,3,1,"2015-11-08","En Route")
      pO.purchaseOrderID should be (1)
      pO.supplierID should be (3)
      pO.employeeID should be (1)
      pO.purchaseOrderDate should be ("2015-11-08")
      pO.purchaseOrderStatus should be ("En Route")
    }
    
  }
  
  purchaseOrderTest
}