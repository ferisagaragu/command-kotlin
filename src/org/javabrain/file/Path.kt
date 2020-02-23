package org.javabrain.file

import org.javabrain.entity.Instruction


class Path(
	private val arg3: String,
	private val instruction: Instruction,
	private val location: String,
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
			if (instruction.prefix.isNotEmpty())
				"${instruction.prefix}-"
			else 
				instruction.prefix 
		}${name}${instruction.suffix}"
	}

	fun getSimpleClassName(): String {
		val out = arg3.split("/")
		return out[out.size -1]
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

	fun getOriginalFileName(): String {
		val out = arg3.split("/")
		return out[out.size -1]
	}

	fun getPackage(): String {
		val packageOut = location.split("\\src")
		val result = packageOut[1].replace("\\", ".")
		return if (result.isNotEmpty()) {
			result.substring(1, result.length)
		} else {
			result
		}
	}

	fun getPackageSpring(): String {
		val packageOut = location.split("\\src\\main\\java")
		var result = ""

		if (packageOut.size > 2) {
			result = packageOut[1].replace("\\", ".")
		} else {
			result = packageOut[0]
		}

		return if (result.isNotEmpty()) {
			result.substring(1, result.length)
		} else {
			result
		}
	}


	private fun convertFileName(instruction: Instruction , name: String): String {
		var out = ""
		if (instruction.attributes.isNotEmpty()) {
			instruction.attributes.forEach { attribute: String ->
				out = when (attribute) {
					"upperCamelCase" -> "${instruction.prefix}${injectableProperties.upperCamelCase(name)}${instruction.suffix}"
					"lowerCamelCase" -> "${instruction.prefix}${injectableProperties.lowerCamelCase(name)}${instruction.suffix}"
					"upperSnakeCase" -> "${instruction.prefix}${injectableProperties.upperSnakeCase(name)}${instruction.suffix}"
					"lowerSnakeCase" -> "${instruction.prefix}${injectableProperties.snakeCase(name)}${instruction.suffix}"
					else -> "${instruction.prefix}$name${instruction.suffix}"
				}
			}
		} else {
			return "${instruction.prefix}$name${instruction.suffix}"
		}
		return out
	}

}