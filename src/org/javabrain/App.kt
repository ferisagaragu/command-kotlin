package org.javabrain

import org.javabrain.console.Print
import org.javabrain.entity.Config


fun main() {
  val config = Config().convertJson()
  val print = Print()

  print.infoNlUndecorated(" Powered by Kotlin")
  println(config.generate["react-structure"])

  print.readLine()

}

