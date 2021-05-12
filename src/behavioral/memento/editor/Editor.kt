package behavioral.memento.editor

import behavioral.memento.commands.Command
import java.io.IOException
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.ByteArrayOutputStream
import javax.swing.JComponent
import java.util.Base64;
import behavioral.memento.history.Memento

import behavioral.memento.history.History
import behavioral.memento.shapes.CompoundShape
import behavioral.memento.shapes.Shape


class Editor : JComponent() {
    private val canvas: Canvas = Canvas(this)
    private val history: History = History()

    var allShapes = CompoundShape()

    fun loadShapes(vararg shapes: Shape) {
        allShapes.clear()
        allShapes.add(*shapes)
        canvas.refresh()
    }

    fun execute(c: Command) {
        history.push(c, Memento(this))
        c.execute()
    }

    fun undo() {
        if (history.undo()) canvas.repaint()
    }

    fun redo() {
        if (history.redo()) canvas.repaint()
    }

    fun backup(): String {
        return try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(allShapes)
            oos.close()
            Base64.getEncoder().encodeToString(baos.toByteArray())
        } catch (e: IOException) {
            ""
        }
    }

    fun restore(state: String?) {
        try {
            val data = Base64.getDecoder().decode(state)
            val ois = ObjectInputStream(ByteArrayInputStream(data))
            allShapes = ois.readObject() as CompoundShape
            ois.close()
        } catch (e: ClassNotFoundException) {
            print("ClassNotFoundException occurred.")
        } catch (e: IOException) {
            print("IOException occurred.")
        }
    }
}