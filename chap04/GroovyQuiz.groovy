import java.awt.event.KeyEvent
import static java.awt.BorderLayout.*
import javax.swing.JFrame
import javax.swing.JOptionPane
import groovy.swing.SwingBuilder

SwingBuilder swing = new SwingBuilder()
swing.edt {
  frame = frame(title: "GroovyQuiz",
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                pack: true, visible: true) {
    borderLayout()
    label("Who is known as 'the father of Java' ?", constraints: cNORTH)
    panel(constraints: CENTER) {
      gridLayout(cols: 1, rows: 0)
      buttonGroup(id: "bgroup")
      ["Larry Wall", "James Gosling",
       "Guido van Rossum"].eachWithIndex{ String option, int i ->
        radioButton("${i+1} $option", mnemonic: KeyEvent."VK_${i+1}",
          actionCommand: option, buttonGroup: bgroup)
      }
    }
    button("Get the Answer!", constraints: context.SOUTH,
      actionPerformed: { evt ->
        if(bgroup.selection) {
          if(bgroup.selection.actionCommand == "James Gosling") {
            JOptionPane.showMessageDialog(frame,
             "You guessed right!",
             "JavaQuiz - Answer",
             JOptionPane.INFORMATION_MESSAGE)
          } else {
            JOptionPane.showMessageDialog(frame,
             "You guessed wrong. Please try again!",
             "JavaQuiz - Answer",
             JOptionPane.ERROR_MESSAGE)
          }
        } else {
          JOptionPane.showMessageDialog(frame,
            "You have not made a selection yet!",
            "JavaQuiz - Answer",
            JOptionPane.WARNING_MESSAGE)
        }
    })
  }
}