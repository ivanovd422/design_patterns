package behavioral.memento.shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D


abstract class BaseShape internal constructor(
    private var x: Int,
    private var y: Int,
    override var color: Color
    ) : Shape {

    private var dx = 0
    private var dy = 0
    private var selected = false

    override fun getX(): Int {
        return x
    }

    override fun getY(): Int {
        return y
    }

    override fun getWidth(): Int {
        return 0
    }

    override fun getHeight(): Int {
        return 0
    }

    override fun drag() {
        dx = x
        dy = y
    }

    override fun moveTo(x: Int, y: Int) {
        this.x = dx + x
        this.y = dy + y
    }

    override fun moveBy(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun drop() {
        x = dx
        y = dy
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight()
    }

    override fun select() {
        selected = true
    }

    override fun unSelect() {
        selected = false
    }

    override fun isSelected(): Boolean {
        return selected
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics)
        } else {
            disableSelectionStyle(graphics)
        }

        // ...
    }

    fun enableSelectionStyle(graphics: Graphics) {
        graphics.color = Color.LIGHT_GRAY
        val g2 = graphics as Graphics2D
        val dash1 = floatArrayOf(2.0f)
        g2.stroke = BasicStroke(
            1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            2.0f, dash1, 0.0f
        )
    }

    fun disableSelectionStyle(graphics: Graphics) {
        graphics.color = color
        val g2 = graphics as Graphics2D
        g2.stroke = BasicStroke()
    }
}