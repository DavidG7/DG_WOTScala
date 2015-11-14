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


object MenuView extends JFXApp {
    

 
  def buildMenu(): Scene ={
 

    val scene = new Scene{

      content = new VBox{
        padding = Insets(100)
        
        children = Seq(new Label{
          text = "Menu"
          style = "-fx-font-size: 24pt"
        
        }
        
        
        ,new VBox {
          children = Seq(
            new Button{
              text = "Customer Orders"
               margin=Insets(10,10,10,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                   ViewMain.stage.scene_=(CustomerOrderView.buildCustomerOrder())
                
              }
            },
             new Button{
              text = "Purchase Orders"
               margin=Insets(10,10,10,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
               
                
              }
            },
             new Button{
              text = "Products"
              margin=Insets(10,10,10,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
               
                
              }
            },
            new Button{
              text = "Log Out"
              style = "-fx-font-size: 12pt"
               margin=Insets(10,10,10,0)
              onAction = handle{
             
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