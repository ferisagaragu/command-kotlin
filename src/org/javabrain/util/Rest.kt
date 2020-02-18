package org.javabrain.util

import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import org.javabrain.enums.Folder
import org.javabrain.file.File

import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import kotlin.reflect.KClass


class Rest {

	private val gson = Gson()


	fun get(urlCall: String, kClass: KClass<out Any>): Pair<Any, List<Any>> {
		return if (!isAvailableNetwork()) {
			val allText = File.read(
				"${Folder.META_DATA.value}\\${
					urlCall.replace(
						"/", 
						"\\"
					)
				}.json"
			)
			convertJsonToObject(allText, kClass)
		} else {
			val url = URL("${Folder.HOST.value}$urlCall")
			val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

			connection.requestMethod = "GET"
			connection.setRequestProperty("Accept", "application/json")

			if (connection.responseCode != 200) {
				throw RuntimeException("Failed : HTTP error code : ${connection.responseCode}")
			}

			val allText = connection.inputStream.bufferedReader().use(BufferedReader::readText)
			connection.disconnect()

			File.write(
				gson.toJson(allText).replace(
					"\"{",
					"{"
				).replace(
					"}\"",
					"}"
				).replace(
					"\\\"",
					"\""
				),
				"${Folder.META_DATA.value}\\${
					urlCall.replace(
						"/", 
						"\\"
					)
				}.json"
			)

			convertJsonToObject(allText, kClass)
		}
	}


	private fun convertJsonToObject(
		allText: String,
		kClass: KClass<out Any>
	): Pair<Any, List<Any>> {
		var list = listOf<Any>()
		var obj = Any()
		val data: Any = gson.fromJson<LinkedTreeMap<String, Any>>(
			allText,
			LinkedTreeMap::class.java
		)["data"]!!

		if (data::class == ArrayList::class) {
			list = toJsonArray(data as List<LinkedTreeMap<String, Any>>, kClass)
		} else {
			obj = toJson(data, kClass)
		}

		return Pair(obj, list)
	}

	private fun toJsonArray(data: List<LinkedTreeMap<String, Any>>, kClass: KClass<out Any>): List<Any> {
		val list = arrayListOf<Any>()

		for (datum in data) {
			list.add(toJson(datum, kClass))
		}

		return list
	}

	private fun toJson(data: Any, kClass: KClass<out Any>): Any {
		val gson = Gson()

		return gson.fromJson(
			gson.toJson(data),
			kClass.java
		)
	}

	private fun isAvailableNetwork(): Boolean{
		return try {
			val url = URL("http://www.google.com")
			val connection: URLConnection = url.openConnection()
			connection.connect()
			true
		} catch (e: Exception) {
    	false
		}
	}

}