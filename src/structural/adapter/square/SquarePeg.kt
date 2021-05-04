package structural.adapter.square

import kotlin.math.pow

class SquarePeg(private val width: Double) {

    fun getWidth(): Double {
        return width
    }

    fun getSquare(): Double {
        return width.pow(2.0)
    }
}