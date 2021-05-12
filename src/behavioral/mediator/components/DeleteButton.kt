package behavioral.mediator.components

import behavioral.mediator.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton


class DeleteButton : JButton("Del"), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(actionEvent: ActionEvent?) {
        mediator?.deleteNote()
    }

    override fun getName(): String {
        return "DelButton"
    }
}