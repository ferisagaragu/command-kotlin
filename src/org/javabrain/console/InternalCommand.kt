package org.javabrain.console

import org.javabrain.entity.Category
import org.javabrain.entity.Command


class InternalCommand {

	private val externalCommand = ExternalCommand()


	fun isCategory(command: Command): Boolean {
		return (command.arg1 == "set") &&
			(command.arg2 == "category") &&
			(command.arg3.isNotEmpty())
	}

	fun setCategory(print: Print, command: Command) {
		var category: Category = externalCommand.getCategory(command.arg1)
		print.category = category.name
	}

}