package behavioral.observer.publisher

import behavioral.observer.listeners.EventListener
import java.io.File
import java.util.ArrayList


class EventManager(vararg operations: String?) {
    var listeners: MutableMap<String, MutableList<EventListener>> = HashMap()

    init {
        for (operation in operations) {
            if (operation == null) continue
            listeners[operation] = ArrayList<EventListener>()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType] ?: return
        users.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType] ?: return
        users.remove(listener)
    }

    fun notify(eventType: String, file: File) {
        val users: List<EventListener> = listeners[eventType] ?: return
        for (listener in users) {
            listener.update(eventType, file)
        }
    }
}