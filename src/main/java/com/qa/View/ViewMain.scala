package com.qa.View

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

/**
 * @author dgordon

 */

object ViewMain extends JFXApp{
  stage = new PrimaryStage{
    title = "NBGardens Warehouse Order Tracking System"
    scene = LoginFX.buildLogin()
    width = 1000
    height = 700
    resizable = false
  }
}