package org.javabrain.entity


data class Command (
	var id: Long,
	var arg1: String,
 	var arg2: String,
	var arg3: String,
	var description: String,
	var instructions: List<Instruction>,
	var category: Category
)