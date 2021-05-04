package creational.builder.cars

import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer

class Car(
    carType: CarType?,
    seats: Int?,
    engine: Engine?,
    transmission: Transmission?,
    tripComputer: TripComputer?,
    gpsNavigator: GPSNavigator?
) {

    private val carType: CarType?
    private val seats: Int?
    private val engine: Engine?
    private val transmission: Transmission?
    private val tripComputer: TripComputer?
    private val gpsNavigator: GPSNavigator?
    private var fuel = 0.0

    init {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        this.tripComputer?.setCar(this)
        this.gpsNavigator = gpsNavigator
    }

    fun getCarType(): CarType? {
        return carType
    }

    fun getTransmission(): Transmission? {
        return transmission
    }

    fun getTripComputer(): TripComputer? {
        return tripComputer
    }

    fun getFuel(): Double? {
        return fuel
    }

    fun getGpsNavigator(): GPSNavigator? {
        return gpsNavigator
    }

    fun getSeats(): Int? {
        return seats
    }

    fun getEngine(): Engine? {
        return engine
    }
}