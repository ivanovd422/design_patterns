package behavioral.observer.listeners

import java.io.File


class LogOpenListener(fileName: String) : EventListener {
    private val log: File = File(fileName)

    override fun update(eventType: String, file: File) {
        println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.name)
    }
}