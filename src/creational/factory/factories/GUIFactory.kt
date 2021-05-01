package creational.factory.factories

import creational.factory.button.Button
import creational.factory.checkbox.Checkbox

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}