package behavioral.memento.commands

import behavioral.memento.editor.Editor
import java.awt.Color


class ColorCommand(private val editor: Editor, private val color: Color) : Command {
    override val name: String
        get() = "Colorize: $color"

    override fun execute() {
        for (child in editor.allShapes.getSelected()) {
            child.color = color
        }
    }
}