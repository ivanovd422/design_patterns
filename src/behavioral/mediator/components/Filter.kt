package behavioral.mediator.components

import behavioral.mediator.Mediator
import behavioral.mediator.Note
import java.awt.event.KeyEvent
import javax.swing.DefaultListModel

import java.util.ArrayList

import javax.swing.ListModel

import javax.swing.JTextField


class Filter : JTextField(), Component {
    private var mediator: Mediator? = null
    private var listModel: ListModel<DefaultListModel<Note>>? = null

    override fun getName(): String {
        return "Filter"
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(keyEvent: KeyEvent?) {
        val start = text
        searchElements(start)
    }

    fun setList(listModel: ListModel<DefaultListModel<Note>>?) {
        this.listModel = listModel
    }

    private fun searchElements(s: String) {
        if (listModel == null) {
            return
        }
        if (s == "") {
            listModel?.let {
                mediator?.setElementsList(it)
            }
            return
        }
        val notes: ArrayList<Note> = ArrayList<Note>()
        for (i in 0 until listModel!!.size) {
            notes.add(listModel!!.getElementAt(i) as Note)
        }
        val listModel: DefaultListModel<Note> = DefaultListModel<Note>()
        for (note in notes) {
            if (note.name.contains(s)) {
                listModel.addElement(note)
            }
        }
    }
}