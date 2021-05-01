package creational.factory

import creational.factory.button.Button
import creational.factory.checkbox.Checkbox
import creational.factory.factories.GUIFactory


class Application(factory: GUIFactory) {

    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()

    fun paint() {
        button.paint()
        checkbox.paint()
    }
}