package structural.bridge.devices

interface Device {
    val isEnabled: Boolean

    fun enable()
    fun disable()

    var volume: Int
    var channel: Int

    fun printStatus()
}