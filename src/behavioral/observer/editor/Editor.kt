package behavioral.observer.editor

import behavioral.observer.publisher.EventManager
import java.io.File


class Editor {
    var events: EventManager = EventManager("open", "save")

    private var file: File? = null

    fun openFile(filePath: String?) {
        file = File(filePath)

        file?.let {
            events.notify("open", it)
        }
    }

    @Throws(Exception::class)
    fun saveFile() {
        file?.let {
            events.notify("open", it)
        } ?: throw Exception("Please open a file first.")
    }
}