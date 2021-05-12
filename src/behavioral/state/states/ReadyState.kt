package behavioral.state.states
import behavioral.state.ui.Player

class ReadyState(player: Player) : State(player) {

    override fun onLock(): String {
        player.changeState(LockedState(player))
        return "Locked..."
    }

    override fun onPlay(): String {
        val action: String = player.startPlayback()
        player.changeState(PlayingState(player))
        return action
    }

    override fun onNext(): String {
        return "Locked..."
    }

    override fun onPrevious(): String {
        return "Locked..."
    }
}