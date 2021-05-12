package behavioral.mediator.components

import behavioral.mediator.Mediator
import behavioral.mediator.Note
import javax.swing.*;


class List(private val listModel: DefaultListModel<Note>) : JList<DefaultListModel<Note>>(), Component {

    private var mediator: Mediator? = null

    init {
        model = listModel as ListModel<DefaultListModel<Note>>
        layoutOrientation = VERTICAL
        val thread = Thread(Hide(this))
        thread.start()
    }

    override fun getName(): String {
        return "List"
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    fun addElement(note: Note) {
        listModel.addElement(note)
        val index = listModel.size() - 1
        selectedIndex = index
        ensureIndexIsVisible(index)
//        mediator?.sendToFilter(listModel)
    }

    fun deleteElement() {
        val index = this.selectedIndex
        try {
            listModel.remove(index)
//            mediator?.sendToFilter(listModel)
        } catch (ignored: ArrayIndexOutOfBoundsException) {
        }
    }

    val currentElement: Note?
        get() = selectedValue as Note?

    private inner class Hide internal constructor(private val list: List) : Runnable {
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(300)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                }
                if (list.isSelectionEmpty) {
                    mediator?.hideElements(true)
                } else {
                    mediator?.hideElements(false)
                }
            }
        }
    }
}