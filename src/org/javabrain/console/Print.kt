package org.javabrain.console

import org.fusesource.jansi.Ansi.Color.BLUE
import org.fusesource.jansi.Ansi.Color.CYAN
import org.fusesource.jansi.Ansi.ansi
import java.io.BufferedReader
import java.io.InputStreamReader


class Print {

	fun readLine(): String {
		print(ansi().fg(BLUE).a(".reactive> ").reset())
		return BufferedReader(
			InputStreamReader(System.`in`)
		).readLine()
	}

	fun info(text: String) {
		print(ansi().fg(CYAN).a(".reactive-info> $text").reset())
	}

	fun infoNl(text: String) {
		println(ansi().fg(CYAN).a(".reactive-info> $text").reset())
	}

	fun infoUndecorated(text: String) {
		print(ansi().fg(CYAN).a(text).reset())
	}

	fun infoNlUndecorated(text: String) {
		println(ansi().fg(CYAN).a(text).reset())
	}

}