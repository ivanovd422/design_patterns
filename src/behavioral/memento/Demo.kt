package behavioral.memento

import behavioral.memento.editor.Editor
import behavioral.memento.shapes.Circle
import behavioral.memento.shapes.CompoundShape
import behavioral.memento.shapes.Dot
import behavioral.memento.shapes.Rectangle
import java.awt.Color


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val editor = Editor()
        editor.loadShapes(
            Circle(10, 10, 10, Color.BLUE),
            CompoundShape(
                Circle(110, 110, 50, Color.RED),
                Dot(160, 160, Color.RED)
            ),
            CompoundShape(
                Rectangle(250, 250, 100, 100, Color.GREEN),
                Dot(240, 240, Color.GREEN),
                Dot(240, 360, Color.GREEN),
                Dot(360, 360, Color.GREEN),
                Dot(360, 240, Color.GREEN)
            )
        )
    }
}