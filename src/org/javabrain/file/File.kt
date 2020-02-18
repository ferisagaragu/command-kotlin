package org.javabrain.file

import java.io.*


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
		fun write(fileContent: String, path: String) {
			val out: Writer = BufferedWriter(
				OutputStreamWriter(
					FileOutputStream(path), "UTF-8"
				)
			)
			out.write(fileContent)
			out.close()
		}
	}

}