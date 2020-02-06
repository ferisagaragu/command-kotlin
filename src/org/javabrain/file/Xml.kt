package org.javabrain.file

import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import javax.xml.parsers.DocumentBuilderFactory

class Xml {

	private var node: Node

	constructor(fileName: String) {
		val inputStream: InputStream = FileInputStream(fileName)
		val reader: Reader = InputStreamReader(inputStream, "UTF-8")
		val `is` = InputSource(reader)
		`is`.encoding = "UTF-8"
		val dbFactory = DocumentBuilderFactory.newInstance()
		val dBuilder = dbFactory.newDocumentBuilder()
		val document = dBuilder.parse(`is`)
		node = document.getElementsByTagName("root").item(0)
	}

	constructor(node: Node) {
		this.node = node
	}

}