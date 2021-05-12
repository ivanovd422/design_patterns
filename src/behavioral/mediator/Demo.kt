package behavioral.mediator

import behavioral.mediator.components.*
import javax.swing.DefaultListModel


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val mediator: Mediator = Editor()

        mediator.registerComponent(Title())
        mediator.registerComponent(TextBox())
        mediator.registerComponent(AddButton())
        mediator.registerComponent(DeleteButton())
        mediator.registerComponent(SaveButton())
        mediator.registerComponent(List(DefaultListModel()))
        mediator.registerComponent(Filter())
        mediator.createGUI()
    }
}