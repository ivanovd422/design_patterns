package creational.abstact_factory.button

class WindowsButton : Button {
    override fun paint() {
        println("You have created WindowsButton.")
    }
}