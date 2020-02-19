package org.javabrain.console

import org.javabrain.entity.Category


class Message(
	private val print: Print,
	private val externalCommand: ExternalCommand,
	private val location: String
) {

	fun presentation() {
		val presentation = externalCommand.getPresentation()
		print.importantNlUndecorated(presentation.logo)
  	print.successNlUndecorated(presentation.subTitle)
  	print.warningNlUndecorated("Commands are executed in ${location}\n")
	}

	fun printBasicInstructions() {
		val categories = externalCommand.getAllCategories()

		print.detailNlUndecorated("Reactive has commands for:")
		categories.forEach { category: Category ->
			print.importantNlUndecorated("-${category.name}")
		}
		print.detailNlUndecorated("Please chose one option\n")
	}


}