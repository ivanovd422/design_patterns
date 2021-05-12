package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics
import java.io.Serializable


interface Shape : Serializable {
    var color: Color

    fun getX(): Int
    fun getY(): Int
    fun getWidth(): Int
    fun getHeight(): Int

    fun drag()
    fun drop()
    fun moveTo(x: Int, y: Int)
    fun moveBy(x: Int, y: Int)
    fun isInsideBounds(x: Int, y: Int): Boolean


    fun select()
    fun unSelect()
    fun isSelected(): Boolean

    fun paint(graphics: Graphics)
}