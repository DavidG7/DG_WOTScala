package com.qa.View


/**
 * @author dgordon
 */
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.layout.VBox
import com.qa.Controller.CustomerOrderController
import scalafx.geometry.Insets


object CustomerOrderView extends JFXApp {
    


  
  def buildCustomerOrder(): Scene ={
 

    val scene = new Scene{
   
      
      content = new HBox{
   
        children = Seq(CustomerOrderTable.buildTable(),
          new VBox {
          margin=Insets(100,100,100,100)
          children = Seq(
            new Button{
              text = "Check Out"
              margin=Insets(40,0,0,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                 CustomerOrderController.updateCustomerOrderStatus()
              }
            },
            
            new Button{
              text = "Return to Menu"
              style = "-fx-font-size: 12pt"
              margin=Insets(40,0,0,0)
              onAction = handle{
                  ViewMain.stage.scene_=(MenuView.buildMenu())
              }
            }
          )
        }
        )
      }
      content 
    }
   scene
  }
}