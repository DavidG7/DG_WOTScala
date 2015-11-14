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
import scalafx.scene.Scene
import com.qa.Controller.LoginController


object LoginFX extends JFXApp {
    

  
  def buildLogin(): Scene ={
 

    val scene = new Scene{
      val userField = new TextField{
          text = "JS117"
          promptText = "Username"
          margin=Insets(10)
        }
      
      val passField = new PasswordField{
          text = "Gnomes4LIFE!"
          promptText = "Password"
          margin=Insets(10)
        }
      
      content = new VBox{
        padding = Insets(200)
        
        children = Seq(new Label{
          text = "Welcome to NBGarView!"
          style = "-fx-font-size: 24pt"
           margin= Insets(1,1,1,25)
        }
        
        
        ,userField,passField,new HBox {
          children = Seq(
            new Button{
              text = "Log In"
              margin=Insets(10,10,10,250)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                val user = userField.text.getValue
                val pass = passField.text.getValue
                if(LoginController.validateLogin(user, pass)){
                  ViewMain.stage.scene_=(MenuView.buildMenu())
                  //Table.build()
                }
              }
            },
            new Button{
              text = "Exit"
              style = "-fx-font-size: 12pt"
              margin=Insets(10)
              onAction = handle{
                System exit(0)
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