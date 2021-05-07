package behavioral.command.editor

import behavioral.command.commands.*

import java.awt.event.ActionListener

import javax.swing.JButton

import java.awt.FlowLayout

import javax.swing.JPanel

import javax.swing.JTextArea

import javax.swing.BoxLayout

import javax.swing.WindowConstants

import javax.swing.JFrame


class Editor {
    var textField: JTextArea? = null
    var clipboard: String? = null
    private val history: CommandHistory = CommandHistory()

    fun init() {
        val frame = JFrame("Text editor (type & use buttons, Luke!)")
        val content = JPanel()
        frame.contentPane = content
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        content.layout = BoxLayout(content, BoxLayout.Y_AXIS)
        textField = JTextArea()
        textField!!.lineWrap = true
        content.add(textField)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        val ctrlC = JButton("Ctrl+C")
        val ctrlX = JButton("Ctrl+X")
        val ctrlV = JButton("Ctrl+V")
        val ctrlZ = JButton("Ctrl+Z")

        ctrlC.addActionListener { executeCommand(CopyCommand(this)) }
        ctrlX.addActionListener { executeCommand(CutCommand(this)) }
        ctrlV.addActionListener { executeCommand(PasteCommand(this)) }
        ctrlZ.addActionListener { undo() }

        buttons.apply {
            add(ctrlC)
            add(ctrlX)
            add(ctrlV)
            add(ctrlZ)
        }

        content.add(buttons)

        frame.apply {
            setSize(450, 200)
            setLocationRelativeTo(null)
            isVisible = true
        }
    }

    private fun executeCommand(command: Command) {
        if (command.execute()) {
            history.push(command)
        }
    }

    private fun undo() {
        if (history.isEmpty) return

        val command: Command? = history.pop()
        command?.undo()
    }
}