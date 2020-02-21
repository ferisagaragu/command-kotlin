package org.javabrain.file

import org.javabrain.entity.Instruction


class Path(
	private val arg3: String,
	private val instruction: Instruction,
	private val injectableProperties: InjectableProperties = InjectableProperties()
) {

	fun getFileName(): String {
		val out = arg3.split("/")
		val name: String = out[out.size -1]
		return "${
			convertFileName(
				instruction, 
				name
			)
		}${instruction.extension}"
	}

	fun getClassName(): String {
		val out = arg3.split("/")
		val name: String = out[out.size -1]
		return "${
			injectableProperties.upperCamelCase(
				name
			)
		}${
			instruction.suffix
		}"
	}

	fun getPath(): String {
		val out = arg3.split("/")
		val name: String = out[out.size -1]
		var dataOut = ""
		for ((index, data) in out.withIndex()) {
			if (index != (out.size - 1)) {
				dataOut += "/$data"
			}
		}
		dataOut = dataOut.replace("//", "/")

		if (instruction.attributes.isNotEmpty()) {
			if (instruction.attributes.contains("contentFolder")) {
				dataOut += "/$name"
			}
		}

		if (instruction.dir.isNotEmpty()) {
			dataOut += "/${instruction.dir}"
		}

		return dataOut
	}

	fun getSimpleFileName(): String {
		val out = arg3.split("/")
		val name: String = out[out.size -1]
		return convertFileName(
			instruction,
			name
		)
	}


	private fun convertFileName(instruction: Instruction , name: String): String {
		var out = ""
		if (instruction.attributes.isNotEmpty()) {
			instruction.attributes.forEach { attribute: String ->
				out = when (attribute) {
					"upperCamelCase" -> "${injectableProperties.upperCamelCase(name)}${instruction.suffix}"
					"lowerCamelCase" -> "${injectableProperties.lowerCamelCase(name)}${instruction.suffix}"
					"upperSnakeCase" -> "${injectableProperties.upperSnakeCase(name)}${instruction.suffix}"
					"lowerSnakeCase" -> "${injectableProperties.snakeCase(name)}${instruction.suffix}"
					else -> "$name${instruction.suffix}"
				}
			}
		} else {
			return "$name${instruction.suffix}"
		}
		return out
	}

}