package creational.builder.cars

import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer


class Manual(
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

    init {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        this.gpsNavigator = gpsNavigator
    }

    fun print(): String {
        var info = ""
        info += "Type of car: $carType\n"
        info += "Count of seats: $seats\n"
        info += """
               Engine: volume - ${engine?.getVolume().toString()}; mileage - ${engine?.getMileage().toString()}
               
               """.trimIndent()
        info += "Transmission: $transmission\n"
        info += if (tripComputer != null) {
            """
     Trip Computer: Functional
     
     """.trimIndent()
        } else {
            """
     Trip Computer: N/A
     
     """.trimIndent()
        }
        info += if (gpsNavigator != null) {
            """
     GPS Navigator: Functional
     
     """.trimIndent()
        } else {
            """
     GPS Navigator: N/A
     
     """.trimIndent()
        }
        return info
    }
}