package com.qa.driver

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import com.qa.view.LoginView


/**
 * @author dgordon

 */
/**Driver for GUI. init a stage and set its scene to LoginView**/
object GUIDriver extends JFXApp{
  stage = new PrimaryStage{
    title = "NBGardens Warehouse Order Tracking System"
    scene = LoginView.buildLogin()
    width = 1000
    height = 700
    resizable = false
  }
}