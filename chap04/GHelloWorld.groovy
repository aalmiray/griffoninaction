import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE

// unsafe Swing threading
new SwingBuilder().frame(title: "Hello World",
  size: [200,100],
  defaultCloseOperation: EXIT_ON_CLOSE,
  visible: true) {
  label("Hello World!")
}
