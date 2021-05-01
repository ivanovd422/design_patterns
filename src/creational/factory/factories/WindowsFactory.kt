package creational.factory.factories

import creational.factory.button.Button
import creational.factory.checkbox.WindowsCheckbox

import creational.factory.button.WindowsButton
import creational.factory.checkbox.Checkbox


class WindowsFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}