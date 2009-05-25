import groovy.swing.SwingBuilder
import javax.swing.SwingUtilities

def swing = new SwingBuilder()
swing.edt {
  frame(title: "Synchronous calls #1", size: [200,100], visible: true) {
    gridLayout(cols: 1, rows:2)
    label(id: "status")
    button("Click me!", actionPerformed: {e ->
       status.text = "attempt #1"
       // fails with an AWT error!
       SwingUtilities.invokeAndWait{ status.text = "attempt #2" }
    })
  }
}