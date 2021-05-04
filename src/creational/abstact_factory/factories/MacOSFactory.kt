package creational.abstact_factory.factories

import creational.abstact_factory.button.Button
import creational.abstact_factory.button.MacOSButton
import creational.abstact_factory.checkbox.Checkbox
import creational.abstact_factory.checkbox.MacOSCheckbox

class MacOSFactory : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}