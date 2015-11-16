package com.qa.View


/**
 * @author dgordon
 */
import scalafx.application.JFXApp
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.TableView
import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.control.TableColumn
import com.qa.Entities.Product
import com.qa.Controller.ProdController

object ProductTable extends JFXApp {

 
  
   def buildTable(): TableView[Product] = {
    
    val ordersList = ObservableBuffer[Product](
        ProdController.getAllProducts
    )

    
    val  content = new TableView(ordersList) {
        
        //val list = generateTableColums[CustomerOrder]()
        margin=Insets(25,25,25,25)
        columns ++=  List(
          new TableColumn[Product, Double] {
            text = "Product ID"
            cellValueFactory = { _.value.productID_ }
            prefWidth = 250
          },
          new TableColumn[Product, String]() {
            text = "Product Name"
            cellValueFactory = { _.value.productName_}
            prefWidth = 250
          }
         
        )

        
        
  }
    content onMouseClicked = handle {
      val activeProductID = content.getSelectionModel.selectedItemProperty.get.productID_.value 
      ProdController.setActiveProductID(activeProductID.toInt)
       
    }
    content
    
   
   
 
  }

  
}
  
  
  
 