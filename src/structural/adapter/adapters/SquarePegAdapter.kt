package structural.adapter.adapters

import structural.adapter.square.SquarePeg

import structural.adapter.round.RoundPeg
import kotlin.math.pow
import kotlin.math.sqrt


class SquarePegAdapter(private val peg: SquarePeg) : RoundPeg() {

    override fun getRadius(): Double {
        val pegHalf = peg.getWidth() / 2
        val pegPowed = pegHalf.pow(2.0)

        return sqrt(pegPowed * 2)
    }
}