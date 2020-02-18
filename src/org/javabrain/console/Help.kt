package org.javabrain.console

import org.javabrain.entity.Category
import org.javabrain.util.Rest


class Help {

	private val rest = Rest()
	private val print = Print()


	fun printBasicInstructions() {
		val categories = rest.get(
			"/category",
			Category::class
		).second as List<Category>

		println("Reactive has commands for:")
		categories.forEach { category: Category ->
			print.importantNlUndecorated("-${category.name}")
		}
		print.detailNlUndecorated("Please chose one option")
		println()
	}


}