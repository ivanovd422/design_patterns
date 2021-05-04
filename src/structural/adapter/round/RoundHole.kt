package structural.adapter.round

class RoundHole(private val radius: Double) {

    fun fits(peg: RoundPeg): Boolean {
        return radius >= peg.getRadius()
    }
}