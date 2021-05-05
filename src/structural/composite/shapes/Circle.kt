package structural.composite.shapes

import java.awt.Color
import java.awt.Graphics

class Circle(
    x: Int,
    y: Int,
    var radius: Int,
    color: Color
) : BaseShape(x, y, color) {

    override val width: Int
        get() = radius * 2

    override val height: Int
        get() = radius * 2

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawOval(x, y, width - 1, height - 1)
    }
}