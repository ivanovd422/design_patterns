package creational.abstact_factory.factories

import creational.abstact_factory.button.Button
import creational.abstact_factory.button.WindowsButton
import creational.abstact_factory.checkbox.Checkbox
import creational.abstact_factory.checkbox.WindowsCheckbox

class WindowsFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}