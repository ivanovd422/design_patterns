package behavioral.mediator

import behavioral.mediator.components.Component
import javax.swing.DefaultListModel
import javax.swing.ListModel


interface Mediator {
    fun addNewNote(note: Note)
    fun deleteNote()
    fun getInfoFromList(note: Note)
    fun saveChanges()
    fun markNote()
    fun clear()
    fun sendToFilter(listModel: ListModel<DefaultListModel<Note>>)
    fun setElementsList(list: ListModel<DefaultListModel<Note>>)
    fun registerComponent(component: Component)
    fun hideElements(flag: Boolean)
    fun createGUI()
}