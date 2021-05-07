package behavioral.command.commands

import behavioral.command.editor.Editor


class PasteCommand(private val editor: Editor) : Command(editor) {

    override fun execute(): Boolean {
        if (editor.clipboard == null || editor.clipboard?.isEmpty() == true) return false

        backup()
        editor.textField?.insert(editor.clipboard, editor.textField?.caretPosition ?: 0)
        return true
    }
}