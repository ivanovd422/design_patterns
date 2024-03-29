package behavioral.state.ui

import behavioral.state.states.ReadyState
import behavioral.state.states.State
import java.util.ArrayList


class Player {
    private var state: State = ReadyState(this)
    private val playlist: MutableList<String> = ArrayList()
    private var currentTrack = 0

    var isPlaying = false

    init {
        isPlaying = true
        for (i in 1..12) {
            playlist.add("Track $i")
        }
    }

    fun changeState(state: State) {
        this.state = state
    }

    fun getState(): State {
        return state
    }

    fun startPlayback(): String {
        return "Playing " + playlist[currentTrack]
    }

    fun nextTrack(): String {
        currentTrack++
        if (currentTrack > playlist.size - 1) {
            currentTrack = 0
        }
        return "Playing " + playlist[currentTrack]
    }

    fun previousTrack(): String {
        currentTrack--
        if (currentTrack < 0) {
            currentTrack = playlist.size - 1
        }
        return "Playing " + playlist[currentTrack]
    }

    fun setCurrentTrackAfterStop() {
        currentTrack = 0
    }
}