import groovy.swing.SwingBuilder
import javax.swing.JFrame
import javax.swing.JFileChooser
import javax.swing.SwingUtilities

public class RevisedGroovyFileViewer {
  static void main(String[] args) {
    RevisedGroovyFileViewer viewer = new RevisedGroovyFileViewer()
  }

  private SwingBuilder swing

  public RevisedGroovyFileViewer() {
    swing = new SwingBuilder()
    swing.edt {
      fileChooser = fileChooser()
      frame = frame( title: "RevisedGroovyFileViewer",
                 defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                 pack: true, visible: true, id: "frame" ) {
        borderLayout()
        button("Click to select a file", constraints: context.NORTH,
               actionPerformed: this.&selectFile)
        scrollPane( constraints: context.CENTER ) {
          textArea( id: "textArea", editable: false, lineWrap: true )
        }
      }
      frame.size = [320,240]
    }
  }

  private void selectFile( event = null ) {
    swing.with {
      int answer = fileChooser.showOpenDialog(frame)
      if( answer == JFileChooser.APPROVE_OPTION ) {
        doOutside {
          String text = fileChooser.selectedFile.text
          doLater {
            textArea.text = text
            textArea.caretPosition = 0
          }
        }
      }
    }
  }

/*
  private void selectFile( event = null ) {
    int answer = swing.fileChooser.showOpenDialog(swing.frame)
    if( answer == JFileChooser.APPROVE_OPTION ) {
      readFile(swing.fileChooser.selectedFile)
    }
  }

  private void readFile( File file ) {
    swing.doOutside {
      String text = file.text
      doLater {
        textArea.text = text
        textArea.caretPosition = 0
      }
    }
  }
*/

/*
  private void readFile( File file ) {
    Thread.start {
      String text = file.text
      SwingUtilities.invokeLater {
        swing.textArea.text = text
        swing.textArea.caretPosition = 0
      }
    }
  }
*/
}