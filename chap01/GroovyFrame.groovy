import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE

new SwingBuilder().edt {
  frame(title: "GroovyFrame", pack: true, visible: true,
        defaultCloseOperation: EXIT_ON_CLOSE) {
    gridLayout(cols: 1, rows: 3)
    textField(id: "input", columns: 20)
    button("Click me!", actionPerformed: {
      output.text = input.text
    })
    textField(id: "output", columns: 20, editable: false)
  }
}