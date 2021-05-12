package behavioral.memento.history

import behavioral.memento.commands.Command
import java.util.ArrayList


class History {
    private var history: MutableList<Pair> = ArrayList()
    private var virtualSize = 0

    private inner class Pair(c: Command, m: Memento) {
        private var command: Command = c
        private var memento: Memento = m

        fun getCommand(): Command {
            return command
        }

        fun getMemento(): Memento {
            return memento
        }

    }

    fun push(c: Command, m: Memento) {
        if (virtualSize != history.size && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1)
        }
        history.add(this.Pair(c, m))
        virtualSize = history.size
    }

    fun undo(): Boolean {
        val pair = undo ?: return false
        System.out.println("Undoing: " + pair.getCommand().name)
        pair.getMemento().restore()
        return true
    }

    fun redo(): Boolean {
        val pair = redo ?: return false
        System.out.println("Redoing: " + pair.getCommand().name)
        pair.getMemento().restore()
        pair.getCommand().execute()
        return true
    }

    private val undo: Pair?
        private get() {
            if (virtualSize == 0) {
                return null
            }
            virtualSize = Math.max(0, virtualSize - 1)
            return history[virtualSize]
        }
    private val redo: Pair?
        private get() {
            if (virtualSize == history.size) {
                return null
            }
            virtualSize = Math.min(history.size, virtualSize + 1)
            return history[virtualSize - 1]
        }
}