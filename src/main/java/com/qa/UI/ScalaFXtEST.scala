package com.qa.UI

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableCell, TableColumn, TableView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle
import com.qa.Entities.Person
import scalafx.beans.property.StringProperty
import com.qa.Entities.Employee
import scalafx.beans.binding.Bindings

object TableWithCustomCellDemo extends JFXApp {

  val characters = ObservableBuffer[Employee](
    new Employee(1,"Lisa Juilu", "LI1","I love gnomes!",1)
   
  )

  stage = new PrimaryStage {
   
    scene = new Scene {
      content = new TableView[Employee](characters) {
        columns ++= List(
          new TableColumn[Employee, String] {
            text = "First Name"
            cellValueFactory = {_.value.employeeID_}
            
            prefWidth = 100
          },
          new TableColumn[Employee, String]() {
            text = "Last Name"
            cellValueFactory = { _.value.employeeName_ }
            prefWidth = 100
          }
          
        )
      }
    }
  }
}