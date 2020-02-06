package org.javabrain.entity

import com.google.gson.Gson
import org.javabrain.enums.StructureEnum
import org.javabrain.file.FileReader


data class Config (
	var generate: Map<String, Object> = LinkedHashMap()
) {

	fun convertJson(): Config {
		var gson = Gson()
		return gson.fromJson(
			FileReader.read(
				"${StructureEnum.ROOT.value()}reactive.json"
			),
			Config().javaClass
		)
	}

}