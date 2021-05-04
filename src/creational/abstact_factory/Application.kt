package creational.abstact_factory

import creational.abstact_factory.button.Button
import creational.abstact_factory.checkbox.Checkbox
import creational.abstact_factory.factories.GUIFactory

class Application(factory: GUIFactory) {

    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()

    fun paint() {
        button.paint()
        checkbox.paint()
    }
}