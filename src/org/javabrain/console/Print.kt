package org.javabrain.console

import org.fusesource.jansi.Ansi.Color.*
import org.fusesource.jansi.Ansi.ansi
import org.javabrain.entity.Category
import org.javabrain.entity.Command
import java.io.BufferedReader
import java.io.InputStreamReader


class Print {

	var category: String = ""

	fun readLine(): Command {
		if (category.isEmpty()) {
			print(ansi().fg(BLUE).a(".reactive> ").reset())
		} else {
			print(ansi().fg(BLUE).a(".reactive-${category}> ").reset())
		}

		val data: List<String> = BufferedReader(
			InputStreamReader(System.`in`)
		).readLine().split(" ")

		return Command(
			id = 0,
			arg1 = data[0],
			arg2 = if (data.size >= 2) data[1] else "" ,
			arg3 = if (data.size >= 3) data[2] else "" ,
			description = "",
			instructions = listOf(),
			category = Category()
		)
	}

	fun detail(text: String) {
		print(ansi().fg(BLUE).a(".reactive-detail> $text").reset())
	}

	fun detailNl(text: String) {
		println(ansi().fg(BLUE).a(".reactive-detail> $text").reset())
	}

	fun detailUndecorated(text: String) {
		print(ansi().fg(BLUE).a(text).reset())
	}

	fun detailNlUndecorated(text: String) {
		println(ansi().fg(BLUE).a(text).reset())
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

	fun success(text: String) {
		print(ansi().fg(GREEN).a(".reactive-success> $text").reset())
	}

	fun successNl(text: String) {
		println(ansi().fg(GREEN).a(".reactive-success> $text").reset())
	}

	fun successUndecorated(text: String) {
		print(ansi().fg(GREEN).a(text).reset())
	}

	fun successNlUndecorated(text: String) {
		println(ansi().fg(GREEN).a(text).reset())
	}

	fun important(text: String) {
		print(ansi().fg(MAGENTA).a(".reactive-important> $text").reset())
	}

	fun importantNl(text: String) {
		println(ansi().fg(MAGENTA).a(".reactive-important> $text").reset())
	}

	fun importantUndecorated(text: String) {
		print(ansi().fg(MAGENTA).a(text).reset())
	}

	fun importantNlUndecorated(text: String) {
		println(ansi().fg(MAGENTA).a(text).reset())
	}

	fun error(text: String) {
		print(ansi().fg(RED).a(".reactive-error> $text").reset())
	}

	fun errorNl(text: String) {
		println(ansi().fg(RED).a(".reactive-error> ${text}\n").reset())
	}

	fun errorUndecorated(text: String) {
		print(ansi().fg(RED).a(text).reset())
	}

	fun errorNlUndecorated(text: String) {
		println(ansi().fg(RED).a(text).reset())
	}

	fun warning(text: String) {
		print(ansi().fg(YELLOW).a(".reactive-error> $text").reset())
	}

	fun warningNl(text: String) {
		println(ansi().fg(YELLOW).a(".reactive-error> $text").reset())
	}

	fun warningUndecorated(text: String) {
		print(ansi().fg(YELLOW).a(text).reset())
	}

	fun warningNlUndecorated(text: String) {
		println(ansi().fg(YELLOW).a(text).reset())
	}

	fun default(text: String) {
		print(ansi().fg(DEFAULT).a(".reactive-error> $text").reset())
	}

	fun defaultNl(text: String) {
		println(ansi().fg(DEFAULT).a(".reactive-error> $text").reset())
	}

	fun defaultUndecorated(text: String) {
		print(ansi().fg(DEFAULT).a(text).reset())
	}

	fun defaultNlUndecorated(text: String) {
		println(ansi().fg(DEFAULT).a(text).reset())
	}

}