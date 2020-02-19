package org.javabrain

import org.fusesource.jansi.AnsiConsole
import org.javabrain.console.ExternalCommand
import org.javabrain.console.InternalCommand
import org.javabrain.console.Message
import org.javabrain.console.Print
import org.javabrain.entity.Command


fun main(args: Array<String>) {

  var root = args[0]
  var location = args[0]
  var exit = false
  var command: Command
  //AnsiConsole.systemInstall()
  val print = Print()
  val internalCommand = InternalCommand(print, root)
  val externalCommand = ExternalCommand(print)
  val message = Message(print, externalCommand, location)

  message.presentation()
  message.printBasicInstructions()

  do {
    try {
      command = print.readLine()

      when(command.arg1) {
        "set" -> when (command.arg2) {
          "category" -> externalCommand.setCategory(command.arg3)
          else -> print.errorNl("'${command.arg2}' is unrecognized command")
        }
        "help" -> println("ayuda")
        "cd" -> location = internalCommand.cd(location, command.arg2)
        "root" -> location = internalCommand.root()
        "bye" -> exit = true

        else -> print.errorNl("'${command.arg1}' is unrecognized command")
      }

		} catch (e: Exception) {
      print.errorNl(e.message!!)
    }
  } while (!exit)

  print.successNlUndecorated("Se you later ;)")
}

