package creational.builder


import creational.builder.cars.CarManualBuilder
import creational.builder.cars.CarBuilder
import creational.builder.director.Director


object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val director = Director()
        val carBuilder = CarBuilder()
        val manualBuilder = CarManualBuilder()

        director.constructSportsCar(carBuilder)
        director.constructSportsCar(manualBuilder)

        val car = carBuilder.result
        val carManual = manualBuilder.result

        println(" Car built: ${car.getCarType()}")
        println(" Car manual built: ${carManual.print()}")
    }
}