package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics


class Circle(x: Int, y: Int, private val radius: Int, color: Color) :
    BaseShape(x, y, color) {
    override fun getWidth(): Int {
        return radius * 2
    }

    override fun getHeight(): Int {
        return radius * 2
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawOval(getX(), getY(), getWidth() - 1, getHeight() - 1)
    }
}