package com.qa.view

/**
 * @author dgordon
 */
import scalafx.application.JFXApp
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.TableView
import com.qa.entity.CustomerOrder
import scalafx.Includes._
import scala.collection.mutable.ObservableBuffer
import com.qa.controller.CustomerOrderController
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.control.TableColumn

object CustomerOrderTable extends JFXApp {

 
  
   def buildTable(): TableView[CustomerOrder] = {
    
    val ordersList = ObservableBuffer[CustomerOrder](
        CustomerOrderController.getAllCustomerOrders()
    )

    
    val  content = new TableView(ordersList) {
        
        //val list = generateTableColums[CustomerOrder]()
        margin=Insets(25,25,25,25)
        columns ++=  List(
          new TableColumn[CustomerOrder, Int] {
            text = "Customer Order ID"
            cellValueFactory = { _.value.customerOrderID_ }
            prefWidth = 125
          },
          new TableColumn[CustomerOrder, Int]() {
            text = "Customer ID"
            cellValueFactory = { _.value.customerID_}
            prefWidth = 125
          },
          new TableColumn[CustomerOrder, String]() {
            text = "Cus. Order Status"
            cellValueFactory = { _.value.customerOrderStatus_}
            prefWidth = 125
          },
          new TableColumn[CustomerOrder, Int]() {
            text = "Employee ID"
            cellValueFactory = { _.value.employeeID_}
            prefWidth = 125
          }
         
        )

        
        
  }
    content onMouseClicked = handle {
      val activeCusOrderID = content.getSelectionModel.selectedItemProperty.get.customerOrderID_.value 
      val activeStatus = content.getSelectionModel.selectedItemProperty.get.customerOrderStatus_.value
      val activeEmployeeID = content.getSelectionModel.selectedItemProperty.get.employeeID_.value
      CustomerOrderController.setActiveOrderID(activeCusOrderID)
      CustomerOrderController.setActiveStatus(activeStatus)
      CustomerOrderController.setActiveEmployeeID(activeEmployeeID)
    }
    content
    
   
   
 
  }

  
}
  
  
  
 