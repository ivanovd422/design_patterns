package creational.factory

import creational.factory.factories.WindowsFactory

import creational.factory.factories.MacOSFactory

import creational.factory.factories.GUIFactory


object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val application = configureApplication()
        application.paint()
    }

    private fun configureApplication(): Application {
        val app: Application
        val factory: GUIFactory
        val osName = System.getProperty("os.name")

        when {
            osName.contains("mac", ignoreCase = true) -> {
                factory = MacOSFactory()
                app = Application(factory)
            }
            else -> {
                factory = WindowsFactory()
                app = Application(factory)
            }
        }

        return app
    }
}