package behavioral.memento.history

import behavioral.memento.editor.Editor

class Memento(val editor: Editor) {
    private val backup: String = editor.backup()

    fun restore() {
        editor.restore(backup)
    }
}