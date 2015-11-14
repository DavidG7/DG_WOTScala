package com.qa.View

/**
 * @author dgordon
 */
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.VBox
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty.sfxStringProperty2jfx
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.control.Label
import scalafx.scene.control.PasswordField
import scalafx.scene.control.TextField
import scalafx.scene.layout.HBox
import scalafx.scene.layout.VBox
import com.qa.Connectors.MongoConnector
import com.qa.Controller.LoginVerifier
import scalafx.scene.Scene
import com.qa.View.CustomerOrderTable
import com.qa.Controller.CustomerOrderController
import com.qa.Controller.CustomerOrderController


object CustomerOrderView extends JFXApp {
    


  
  def buildCustomerOrder(): Scene ={
 

    val scene = new Scene{
   
      
      content = new HBox{
   
        children = Seq(CustomerOrderTable.buildTable(),
          new VBox {
          children = Seq(
            new Button{
              text = "Check Out"
             
              style = "-fx-font-size: 12pt"
              onAction = handle{
                 CustomerOrderController.updateCustomerOrderStatus()
              }
            },
            new Button{
              text = "View Customer Order"
              style = "-fx-font-size: 12pt"
             
              onAction = handle{
              
              }
            },
            new Button{
              text = "Return to Menu"
              style = "-fx-font-size: 12pt"
             
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