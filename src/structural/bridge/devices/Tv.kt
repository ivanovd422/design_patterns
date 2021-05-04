package structural.bridge.devices

class Tv : Device {

    override var isEnabled = false
        private set

    override var volume = 30
        set(value) {
            field = when {
                volume > 100 -> {
                    100
                }
                volume < 0 -> {
                    0
                }
                else -> {
                    volume
                }
            }
        }

    override var channel = 1

    override fun enable() {
        isEnabled = true
    }

    override fun disable() {
        isEnabled = false
    }

    override fun printStatus() {
        println("------------------------------------")
        println("| I'm TV set.")
        println("| I'm " + if (isEnabled) "enabled" else "disabled")
        println("| Current volume is $volume%")
        println("| Current channel is $channel")
        println("------------------------------------\n")
    }
}