package behavioral.mediator.components

import behavioral.mediator.Mediator
import java.awt.event.KeyEvent
import javax.swing.JTextField


class Title : JTextField(), Component {

    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(keyEvent: KeyEvent?) {
        mediator?.markNote()
    }

    override fun getName(): String {
        return "Title"
    }
}