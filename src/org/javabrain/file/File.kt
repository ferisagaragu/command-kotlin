package org.javabrain.file

import java.io.*
import java.io.File


class File {

	companion object {
		@JvmStatic
		@Throws
		fun read(path: String): String {
			var out = ""

			var inFile = BufferedReader(
				InputStreamReader(
					FileInputStream(File(path)),
					"UTF8"
				)
			)

			var str: String?
			while (inFile.readLine().also { str = it } != null) {
				out += str + "\n"
			}

			return out.substring(0, out.length - 1)
		}

		@JvmStatic
		@Throws
		fun write(fileContent: String, location: String, path: String, fileName: String) {
			val file = File("$location${path}")
			val fileOut = File("${file.absolutePath}\\$fileName")
			file.mkdirs()

			val out: Writer = BufferedWriter(
				OutputStreamWriter(
					FileOutputStream(fileOut),
					"UTF-8"
				)
			)

			out.write(fileContent)
			out.close()
		}

		@JvmStatic
		@Throws
		fun dir(location: String, path: String) {
			val file = File("$location${path}")
			file.mkdirs()
		}
	}

}