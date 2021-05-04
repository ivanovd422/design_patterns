package creational.builder.cars

import creational.builder.Builder
import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer


class CarBuilder : Builder {

    private var type: CarType? = null
    private var seats: Int? = null
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null

    val result: Car
        get() = Car(type, seats, engine, transmission, tripComputer, gpsNavigator)

    override fun setCarType(type: CarType?) {
        this.type = type
    }

    override fun setSeats(seats: Int?) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine?) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission?) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer?) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator?) {
        this.gpsNavigator = gpsNavigator
    }
}