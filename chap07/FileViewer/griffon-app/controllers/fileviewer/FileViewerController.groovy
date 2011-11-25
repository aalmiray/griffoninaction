package fileviewer

import javax.swing.JFileChooser
import griffon.transform.Threading

class FileViewerController {
   def model
   def view

   def quit = { evt = null ->
      app.shutdown()
   }

   private doWithSelectedFile = { Map technique, Closure codeBlock ->
      def openResult = view.fileChooser.showOpenDialog(view.mainWindow)
      if( JFileChooser.APPROVE_OPTION == openResult ) {
          File file = new File(view.fileChooser.selectedFile.toString())
          technique.text = ""
          technique.enabled = false
          codeBlock(file)
      }
   }

   @Threading(Threading.Policy.SKIP)
   def readFileNoThreading = { evt = null ->
       def technique = model.technique1
       doWithSelectedFile(technique) { file ->
           technique.text = file.text
           technique.enabled = true
       }
   }

   def readFileWithThreading = { evt = null ->
       def technique = model.technique2
       doWithSelectedFile(technique) { file ->
           String text = file.text
           technique.text = text
           technique.enabled = true
       }
   }

   def readFileWithWorker = { evt = null ->
       def technique = model.technique3
       doWithSelectedFile(technique) { file ->
           jxwithWorker(start: true) {
               work { file.text }
               onDone {
                   technique.text = get()
                   technique.enabled = true
               }
           }
       }
   }

   def readFileWithUpdates = { evt = null ->
       def technique = model.technique4
       doWithSelectedFile(technique) { file ->
           jxwithWorker(start: true) {
               onInit {
                   technique.progress.with {
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
                   technique.progress.string = chunks[0]+ " %"
                   technique.progress.value = chunks[0]
               }
               onDone {
                   technique.text = get()
                   technique.progress.stringPainted = false
                   technique.progress.indeterminate = true
                   technique.enabled = true
               }
           }
       }
   }
}
