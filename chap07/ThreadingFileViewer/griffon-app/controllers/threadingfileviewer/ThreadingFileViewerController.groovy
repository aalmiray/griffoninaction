package threadingfileviewer
import javax.swing.JFileChooser

class ThreadingFileViewerController {
   def model
   def view

   def quit = { evt = null ->
      app.shutdown()
   }
}
