package creational.factory.factories

import creational.factory.button.Button
import creational.factory.checkbox.MacOSCheckbox

import creational.factory.button.MacOSButton
import creational.factory.checkbox.Checkbox


class MacOSFactory : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}