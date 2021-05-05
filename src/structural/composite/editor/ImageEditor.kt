package structural.composite.editor

import javax.swing.BorderFactory
import javax.swing.JPanel
import javax.swing.WindowConstants
import javax.swing.JFrame
import java.awt.event.MouseAdapter
import structural.composite.shapes.CompoundShape
import structural.composite.shapes.Shape
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseEvent
import javax.swing.border.Border


class ImageEditor {

    private val canvas: EditorCanvas = EditorCanvas()
    private val allShapes = CompoundShape()


    fun loadShapes(vararg shapes: Shape) {
        allShapes.clear()
        allShapes.add(*shapes)
        canvas.refresh()
    }

    private inner class EditorCanvas() : Canvas() {
        var frame: JFrame? = null
        private val PADDING = 10


        init {
            createFrame()
            refresh()
            addMouseListener(object : MouseAdapter() {
                override fun mousePressed(e: MouseEvent) {
                    allShapes.unSelect()
                    allShapes.selectChildAt(e.x, e.y)
                    e.component.repaint()
                }
            })
        }

        fun createFrame() {
            frame = JFrame()
            frame?.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame?.setLocationRelativeTo(null)
            val contentPanel = JPanel()
            val padding: Border = BorderFactory.createEmptyBorder(
                PADDING,
                PADDING,
                PADDING,
                PADDING
            )
            contentPanel.border = padding
            frame?.contentPane = contentPanel
            frame?.add(this)
            frame?.isVisible = true
            frame?.contentPane?.background = Color.LIGHT_GRAY
        }

        fun refresh() {
            this.setSize(width, height)
            frame?.pack()
        }

        override fun paint(graphics: Graphics) {
            allShapes.paint(graphics)
        }
    }

}

