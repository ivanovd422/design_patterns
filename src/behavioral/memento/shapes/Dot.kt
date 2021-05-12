package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics


class Dot(x: Int, y: Int, color: Color) : BaseShape(x, y, color) {
    private val DOT_SIZE = 3

    override fun getWidth(): Int {
        return DOT_SIZE
    }

    override fun getHeight(): Int {
        return DOT_SIZE
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(getX() - 1, getY() - 1, getWidth(), getHeight())
    }
}