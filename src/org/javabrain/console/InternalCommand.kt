package org.javabrain.console

import java.io.File


class InternalCommand(
	private val print: Print,
	private val root: String
) {

	@Throws
	fun cd(root: String, arg2: String): String {
		if (arg2.isNotEmpty()) {
			if (File("$root$arg2").exists()) {
				val path: String = File("$root$arg2").absolutePath;
				print.infoNl("Location change to: $path")
				return path
			} else {
				throw Exception("the folder does not exist")
			}
		} else {
			throw Exception("cd requires more than one argument")
		}
	}

	@Throws
	fun root(): String {
		print.infoNl("Location change to: $root")
		return root
	}

}