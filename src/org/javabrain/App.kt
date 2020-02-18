package org.javabrain

import org.javabrain.console.ExternalCommand
import org.javabrain.console.Help
import org.javabrain.console.InternalCommand
import org.javabrain.console.Print
import org.javabrain.entity.Command
import org.javabrain.entity.Presentation
import org.javabrain.util.Rest
import java.lang.Exception


@Throws
fun main() {

  val print = Print()
  val rest = Rest()
  val help = Help()
  val internalCommand = InternalCommand()
  val externalCommand = ExternalCommand()
  val presentation = externalCommand.getPresentation()

  var categorySelect = false
  var command = Command()

  print.importantNlUndecorated(presentation.logo)
  print.successNlUndecorated(presentation.subTitle)
  println()

  do {
    try {
    	if (!categorySelect) {
        help.printBasicInstructions()
      }
      command = print.readLine()

      if (!categorySelect) {
        internalCommand.setCategory(print, command)
        categorySelect = true
      }

      if (internalCommand.isCategory(command)) {

      }
		} catch (e: Exception) {
      println(e.message as Any)
    }
  } while (command.arg1 != "bye")

  print.successNlUndecorated("Se you later ;)")
}

