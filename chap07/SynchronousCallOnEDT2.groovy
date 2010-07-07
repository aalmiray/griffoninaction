import groovy.swing.SwingBuilder

def swing = new SwingBuilder()
swing.edt {
  frame(title: "Synchronous calls #2", size: [200,100], visible: true) {
    gridLayout(cols: 1, rows:2)
    label(id: "status")
    button("Click me!", actionPerformed: {e ->
       status.text = "attempt #1"
       edt{ status.text = "attempt #2" }
    })
  }
}