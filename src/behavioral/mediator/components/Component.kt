package behavioral.mediator.components

import behavioral.mediator.Mediator

interface Component {
    fun setMediator(mediator: Mediator)
    fun getName(): String
}