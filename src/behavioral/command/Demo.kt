package behavioral.command

import behavioral.command.editor.Editor


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val editor = Editor()
        editor.init()
    }
}