package creational.builder.components

import creational.builder.cars.Car


class TripComputer {
    private var car: Car? = null

    fun setCar(car: Car?) {
        this.car = car
    }

    fun showFuelLevel() {
        println("Fuel level: " + car?.getFuel())
    }

    fun showStatus() {
        if (car?.getEngine()?.isStarted() == true) {
            println("Car is started")
        } else {
            println("Car isn't started")
        }
    }
}