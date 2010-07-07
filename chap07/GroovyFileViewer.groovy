import groovy.swing.SwingBuilder
import javax.swing.JFrame
import javax.swing.JFileChooser

public class GroovyFileViewer {
  static void main(String[] args) {
    GroovyFileViewer viewer = new GroovyFileViewer()
  }

  private SwingBuilder swing

  public GroovyFileViewer() {
    swing = new SwingBuilder()
    swing.fileChooser(id: "fileChooser")
    swing.frame( title: "GroovyFileViewer",
                 defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                 pack: true, visible: true, id: "frame" ) {
      borderLayout()
      button("Click to select a file", constraints: context.NORTH,
             actionPerformed: this.&selectFile)
      scrollPane( constraints: context.CENTER ) {
        textArea( id: "textArea", editable: false, lineWrap: true )
      }
    }
    swing.frame.size = [320,240]
  }

  private void selectFile( event = null ) {
    int answer = swing.fileChooser.showOpenDialog(swing.frame)
    if( answer == JFileChooser.APPROVE_OPTION ) {
      readFile(swing.fileChooser.selectedFile)
    }
  }

  private void readFile( File file ) {
    swing.textArea.text = file.text
    swing.textArea.caretPosition = 0
  }
}