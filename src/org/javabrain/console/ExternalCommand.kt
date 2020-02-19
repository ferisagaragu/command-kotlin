package org.javabrain.console

import org.javabrain.entity.Category
import org.javabrain.entity.Presentation
import org.javabrain.util.Rest


class ExternalCommand(
	private val print: Print,
	private val rest: Rest = Rest()
) {

	fun getPresentation(): Presentation {
		return rest.get(
    	"/presentation",
    	Presentation::class
  	).first as Presentation
	}

	fun getCategory(categoryName: String): Category {
		return rest.get(
			"/category/${categoryName}",
			Category::class
		).first as Category
	}

	fun getAllCategories(): List<Category> {
		return rest.get(
			"/category",
			Category::class
		).second as List<Category>
	}

	fun setCategory(categorySearch: String) {
		var category: Category = getCategory(categorySearch)
		print.category = category.name
	}

}