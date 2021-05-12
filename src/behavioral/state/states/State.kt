package behavioral.state.states
import behavioral.state.ui.Player

abstract class State(val player: Player) {
    abstract fun onLock(): String
    abstract fun onPlay(): String
    abstract fun onNext(): String
    abstract fun onPrevious(): String
}