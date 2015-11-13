package com.qa.UIFX

/**
 * @author dgordon
 */
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableCell, TableColumn, TableView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle
import com.qa.Entities.CustomerOrder
import com.qa.Entities.Person
import com.qa.Connectors.MongoConnector
import com.qa.Connectors.SQLConnector


object Table extends JFXApp {

  
  

  def build(){
    val test = new Array[Person](2)
    test(0) = new Person("Peggy", "Sue", Color.Violet)
    test(1) = new Person("Rocky", "Raccoon", Color.GreenYellow)
    drawTable(test)
  }
  


  def drawTable[T](orders: Array[T]){
    val ordersList = ObservableBuffer[T](
        orders
    )
    
    
  

  stage = new PrimaryStage {
    title = "Warehouse Order Tracking System"
    scene = new Scene {
      content = new TableView[T](ordersList) {
        
        //val list = generateTableColums[CustomerOrder]()
        columns ++=  List(
          new TableColumn[T, String] {
            text = "First Name"
            cellValueFactory = { _.value.asInstanceOf[Person].firstName }
            prefWidth = 250
          },
          new TableColumn[T, String]() {
            text = "Last Name"
            cellValueFactory = { _.value.asInstanceOf[Person].lastName}
            prefWidth = 250
          }
          
        )
  }
 
      }
    }
  }
}
  
  
  
 