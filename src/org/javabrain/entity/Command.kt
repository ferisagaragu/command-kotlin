package org.javabrain.entity

data class Command (
	var id: Long,
	var arg1: String,
 	var arg2: String,
	var arg3: String,
	var description: String
) {
	constructor() : this(
		id = 0,
		arg1 = "",
		arg2 = "",
		arg3 = "",
		description = ""
	)
}