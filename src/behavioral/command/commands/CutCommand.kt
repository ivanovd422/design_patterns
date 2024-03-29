package behavioral.command.commands

import behavioral.command.editor.Editor


class CutCommand(private val editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        if (editor.textField == null) return false

        if (editor.textField!!.selectedText.isEmpty()) return false
        backup()
        val source = editor.textField!!.text
        editor.clipboard = editor.textField!!.selectedText
        editor.textField!!.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField!!.selectionStart)
        val end = source.substring(editor.textField!!.selectionEnd)
        return start + end
    }
}