package org.javabrain.file

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader


class FileReader {

	companion object {
		@JvmStatic
		@Throws(Exception::class)
		fun read(path: String): String {
			var out = ""

			var inFile = BufferedReader(
				InputStreamReader(
					FileInputStream(File(path)),
					"UTF8"
				)
			)

			var str: String? = ""
			while (inFile.readLine().also { str = it } != null) {
				out += str + "\n"
			}

			return out.substring(0, out.length - 1)
		}
	}

}