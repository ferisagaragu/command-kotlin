package org.javabrain.file

class InjectableProperties {

	fun upperCamelCase(upperCamel: String): String {
		if (upperCamel != null) {
			val split = upperCamel.split("-".toRegex()).toTypedArray()
			var out: String = ""
			for (i in split.indices) {
				out += capitalize(split[i])
			}
			return out
		}
		return ""
	}

	fun lowerCamelCase(lowerCamel: String): String {
		if (lowerCamel != null) {
			val split = lowerCamel.split("-".toRegex()).toTypedArray()
			var out: String = ""
			for (i in split.indices) {
				out += if (i == 0) {
					split[i]
				} else {
					capitalize(split[i])
				}
			}
			return out
		}
		return ""
	}

	fun snakeCase(snakeCase: String): String {
		return snakeCase.replace("-", "_") ?: ""
	}

	fun upperSnakeCase(snakeCase: String): String {
		return snakeCase?.replace("-", "_")?.toUpperCase() ?: ""
	}


	private fun capitalize(str: String): String {
		return if (str == null || str.isEmpty()) {
			str
		} else str.substring(0, 1).toUpperCase() + str.substring(1)
	}

}