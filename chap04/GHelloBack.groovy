import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE

new SwingBuilder().frame(title: "Hello World",
  defaultCloseOperation: EXIT_ON_CLOSE,
  size: [200, 140], visible: true) {
  gridLayout(cols: 1, rows: 3)
  tf = textField(columns: 20)
  button("Say 'Hello'", actionPerformed: {
    String text = tf.text.trim()
    if(text) lbl.text = "Hello ${text}!"
  })
  lbl = label()
}
