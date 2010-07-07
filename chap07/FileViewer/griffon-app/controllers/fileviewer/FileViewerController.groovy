package fileviewer 
import javax.swing.JFileChooser

class FileViewerController {
   def model
   def view

   def quit = { evt = null ->
      app.shutdown()
   }

   private doWithSelectedFile = { Map modelTarget, Closure codeBlock ->
      def openResult = view.fileChooser.showOpenDialog(view.mainWindow)
      if( JFileChooser.APPROVE_OPTION == openResult ) {
          File file = new File(view.fileChooser.selectedFile.toString())
          modelTarget.text = ""
          modelTarget.enabled = false
          codeBlock(file)
      }
   }

   def readFileNoThreading = { evt = null ->
       def modelTarget = model.technique1
       doWithSelectedFile(modelTarget) { file ->
           modelTarget.text = file.text
           modelTarget.enabled = true
       }
   }

   def readFileWithThreading = { evt = null ->
       def modelTarget = model.technique2
       doWithSelectedFile(modelTarget) { file ->
           doOutside {
               String text = file.text
               doLater {
                   modelTarget.text = text
                   modelTarget.enabled = true
               }
           }
       }
   }

   def readFileWithWorker = { evt = null ->
       def modelTarget = model.technique3
       doWithSelectedFile(modelTarget) { file ->
           jxwithWorker(start: true) {
               work { file.text }
               onDone {
                   modelTarget.text = get()
                   modelTarget.enabled = true
               }
           }
      }
   }

   def readFileWithUpdates = { evt = null ->
       def modelTarget = model.technique4
       doWithSelectedFile(modelTarget) { file ->
           jxwithWorker(start: true) {
               onInit {
                   modelTarget.progress.with {
                       setIndeterminate(false)
                       setStringPainted(true)
                       setString("0 %")
                   }
               }
               work {
                   int max = file.size()
                   def buffer = new char[max/10]
                   def text = new StringBuffer()
                   file.withReader { reader ->
                       (1..10).each { i ->
                           reader.read(buffer, 0, buffer.size())
                           text.append(buffer)
                           Thread.sleep(300)
                           publish(i*10)
                       }
                   }
                   text.toString()
               }
               onUpdate { chunks ->
                   modelTarget.progress.string = chunks[0]+ " %"
                   modelTarget.progress.value = chunks[0]
               }
               onDone {
                   modelTarget.text = get()
                   modelTarget.progress.stringPainted = false
                   modelTarget.progress.indeterminate = true
                   modelTarget.enabled = true
               }
           }
       }
   }
}
