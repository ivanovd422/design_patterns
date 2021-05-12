package behavioral.memento.commands

import behavioral.memento.editor.Editor

class MoveCommand(val editor: Editor) : Command {

    private var startX = 0
    private var startY = 0
    private var endX = 0
    private var endY = 0
    override val name: String
        get() = "Move by X:" + (endX - startX) + " Y:" + (endY - startY)

    fun start(x: Int, y: Int) {
        startX = x
        startY = y
        for (child in editor.allShapes.getSelected()) {
            child.drag()
        }
    }

    fun move(x: Int, y: Int) {
        for (child in editor.allShapes.getSelected()) {
            child.moveTo(x - startX, y - startY)
        }
    }

    fun stop(x: Int, y: Int) {
        endX = x
        endY = y
        for (child in editor.allShapes.getSelected()) {
            child.drop()
        }
    }

    override fun execute() {
        for (child in editor.allShapes.getSelected()) {
            child.moveBy(endX - startX, endY - startY)
        }
    }
}