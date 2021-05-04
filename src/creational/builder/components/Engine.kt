package creational.builder.components

class Engine(
    private val volume: Double,
    private var mileage: Double
) {

    private var started = false

    fun on() {
        started = true
    }

    fun off() {
        started = false
    }

    fun isStarted(): Boolean {
        return started
    }

    fun go(mileage: Double) {
        if (started) {
            this.mileage += mileage
        } else {
            System.err.println("Cannot go(), you must start engine first!")
        }
    }

    fun getVolume(): Double {
        return volume
    }

    fun getMileage(): Double {
        return mileage
    }
}