package behavioral.mediator.components

import behavioral.mediator.Mediator
import behavioral.mediator.Note
import java.awt.event.ActionEvent
import javax.swing.JButton


class AddButton : JButton("Add"), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(actionEvent: ActionEvent?) {
        mediator?.addNewNote(Note())
    }

    override fun getName(): String {
        return "AddButton"
    }
}