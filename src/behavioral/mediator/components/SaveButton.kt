package behavioral.mediator.components

import behavioral.mediator.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton


class SaveButton : JButton("Save"), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(actionEvent: ActionEvent?) {
        mediator?.saveChanges()
    }

    override fun getName(): String {
        return "SaveButton"
    }
}