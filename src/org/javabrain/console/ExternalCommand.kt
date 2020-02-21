package org.javabrain.console

import org.javabrain.entity.Category
import org.javabrain.entity.Command
import org.javabrain.entity.Instruction
import org.javabrain.entity.Presentation
import org.javabrain.enums.CommandAttribute
import org.javabrain.file.File
import org.javabrain.file.InjectableProperties
import org.javabrain.file.Path
import org.javabrain.util.Rest


class ExternalCommand(
	private val print: Print,
	private val rest: Rest = Rest(),
	private val injectableProperties: InjectableProperties = InjectableProperties(),
	private var category: Category = Category()
) {

	fun getPresentation(): Presentation {
		return rest.get(
    	"/presentation",
    	Presentation::class
  	).first as Presentation
	}

	fun getAllCategories(): List<Category> {
		return rest.get(
			"/category",
			Category::class
		).second as List<Category>
	}

	fun setCategory(categoryName: String) {
		category = rest.get(
			"/category/${categoryName}",
			Category::class
		).first as Category
		print.category = category.name

		var commands: List<Command> = rest.get(
			"/command/${category.id}",
			Command::class
		).second as List<Command>

		println()
		commands.forEach { command: Command ->
			print.successUndecorated("\t${command.arg1} ")
			print.infoUndecorated("${command.arg2} ")
			print.importantUndecorated("${command.arg3} ")
			print.warningNlUndecorated(command.description)
		}
		println()
	}

	@Throws
	fun getCommand(
		arg1: String,
		arg2: String,
		arg3: String,
		location: String
	): Any {

		if (category.id == -1) {
			throw Exception("Category is't select")
		}

		val command = rest.get(
			"/command/${category.id}/$arg1/$arg2",
			Command::class
		).first as Command

		if (command.arg3 == CommandAttribute.ARG3.value) {
			if (arg3.isEmpty()) {
				throw Exception("Command requires a third parameter")
			}
		}

		command.instructions.forEach { instruction: Instruction ->
			val path = Path(arg3, instruction)

			File.write(
				injectableProperties(path, instruction),
				location,
				path.getPath(),
				path.getFileName()
			)
		}

		return command
	}


	private fun injectableProperties(path: Path, instruction: Instruction): String {
		return instruction.metaData
			.replace(
				"\${upperCamelCase}",
				injectableProperties.upperCamelCase(path.getClassName())
			)
			.replace(
				"\${lowerCamelCase}",
				injectableProperties.lowerCamelCase(path.getClassName())
			)
			.replace(
				"\${upperSnakeCase}",
				injectableProperties.upperSnakeCase(path.getClassName())
			)
			.replace(
				"\${lowerSnakeCase}",
				injectableProperties.lowerCamelCase(path.getClassName())
			)
			.replace(
				"\${fileName}",
				path.getSimpleFileName()
			)

			/*
			${version}	Mostrara la version de Reactive Command
			${metaFileName}	Mostrara el nombre real del archivo .xml con su ruta relativa
			${developMode}	Mostrara si la configuración esta en modo desarrollador con [DEVELOP-MODE]
			${defaultFolder}	Mostrara el folder donde se encuentra, siempre se posicionara en el folder por default src


			${upperCamelCase}	Mostrara el nombre del archivo convertido en camel case con la primer letra en mayúscula
			${lowerCamelCase}	Mostrara el nombre del archivo convertido en camel case
			${upperSnakeCase}	Mostrara el nombre del archivo convertido en snake case con la primer letra en mayúscula
			${lowerSnakeCase}	Mostrara el nombre del archivo convertido en snake case


			${fileName}	Mostrara el nombre del archivo sin extension
			${(}	Mostrara <
			${)}	Mostrara >
			${and}	Mostrara &
			${or}	Mostrara símbolo or
			 */
	}

}