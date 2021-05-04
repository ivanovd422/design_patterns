package creational.abstact_factory

import creational.abstact_factory.factories.GUIFactory
import creational.abstact_factory.factories.MacOSFactory
import creational.abstact_factory.factories.WindowsFactory

object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val app = configureApplication()
        app.paint()
    }

    private fun configureApplication(): Application {
        val app: Application
        val factory: GUIFactory
        val osName = System.getProperty("os.name")

        if (osName.contains(other = "mac", ignoreCase = true)) {
            factory = MacOSFactory()
            app = Application(factory)
        } else {
            factory = WindowsFactory()
            app = Application(factory)
        }

        return app
    }
}