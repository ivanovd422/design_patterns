package structural.adapter

import structural.adapter.adapters.SquarePegAdapter
import structural.adapter.square.SquarePeg
import structural.adapter.round.RoundPeg
import structural.adapter.round.RoundHole

object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val hole = RoundHole(5.0)
        val rpeg = RoundPeg(5.0)

        if (hole.fits(rpeg)) {
            println("Round peg r5 fits round hole r5.")
        }

        val smallSqPeg = SquarePeg(2.0)
        val largeSqPeg = SquarePeg(20.0)

        val smallSqPegAdapter = SquarePegAdapter(smallSqPeg)
        val largeSqPegAdapter = SquarePegAdapter(largeSqPeg)

        if (hole.fits(smallSqPegAdapter)) {
            println("Square peg w2 fits round hole r5.")
        }

        if (hole.fits(largeSqPegAdapter).not()) {
            println("Square peg w20 does not fit into round hole r5.")
        }
    }
}