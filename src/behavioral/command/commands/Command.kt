package behavioral.command.commands

import behavioral.command.editor.Editor

abstract class Command constructor(private val editor: Editor) {

    private var backup: String? = null

    abstract fun execute(): Boolean

    fun backup() {
        backup = editor.textField?.text
    }

    fun undo() {
        editor.textField?.text = backup
    }
}