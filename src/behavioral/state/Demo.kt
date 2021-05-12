package behavioral.state

import behavioral.state.ui.UI

import behavioral.state.ui.Player


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val player = Player()
        val ui = UI(player)
        ui.init()
    }
}