package creational.abstact_factory.factories

import creational.abstact_factory.button.Button
import creational.abstact_factory.checkbox.Checkbox

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}