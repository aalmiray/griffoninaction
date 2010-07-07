package threadingfileviewer
import javax.swing.JFileChooser

class ReadingTabController {
   def model
   def view

   private fileChooser
   private mainWindow

   void mvcGroupInit(Map args) {
      mainWindow = args.mainWindow
      fileChooser = args.fileChooser
   }

   def readFileNoThreading = this.&readFile.curry { file ->
      model.text = file.text
      model.enabled = true
   }

   def readFileWithThreading = this.&readFile.curry { file ->
      doOutside {
         String text = file.text
         doLater {
            model.text = text
            model.enabled = true
         }
      }
   }

   def readFileWithWorker = this.&readFile.curry { file ->
      jxwithWorker(start: true) {
         work { file.text }
         onDone {
            model.text = get()
            model.enabled = true
         }
      }
   }

   def readFileWithUpdates = this.&readFile.curry { file ->
      jxwithWorker(start: true) {
         onInit {
            view.progress.with {
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
            view.progress.string = chunks[0]+ " %"
            view.progress.value = chunks[0]
         }
         onDone {
            model.text = get()
            view.progress.stringPainted = false
            view.progress.indeterminate = true
            model.enabled = true
         }
      }
   }

   private void readFile(Closure codeBlock, evt) {
      def openResult = fileChooser.showOpenDialog(mainWindow)
      if( JFileChooser.APPROVE_OPTION == openResult ) {
         File file = new File(fileChooser.selectedFile.toString())
         model.text = ""
         model.enabled = false
         codeBlock(file)
      }
   }
}
