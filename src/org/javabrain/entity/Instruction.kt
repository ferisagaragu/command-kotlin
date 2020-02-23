package org.javabrain.entity


class Instruction(
	var id: Long,
	var platform: String,
	var extension: String,
	var dir: String,
	var suffix: String,
	var prefix: String,
	var metaData: String,
	var command: Command,
	var type: InstructionType,
	var attributes: List<String>,
	var messages: List<Message>
)