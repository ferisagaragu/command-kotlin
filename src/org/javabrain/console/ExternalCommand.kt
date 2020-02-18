package org.javabrain.console

import org.javabrain.entity.Category
import org.javabrain.util.Rest

class ExternalCommand {

	private val rest = Rest()


	fun getCategory(categoryName: String): Category {
		return rest.get(
			"/category/${categoryName}",
			Category::class
		).first as Category
	}

}