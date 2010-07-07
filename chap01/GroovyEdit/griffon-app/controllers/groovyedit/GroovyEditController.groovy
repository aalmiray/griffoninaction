package groovyedit

import javax.swing.JFileChooser

class GroovyEditController {
   def view

   def openFile = {
      def openResult = view.fileChooserWindow.showOpenDialog(view.fileViewerWindow)
      if( JFileChooser.APPROVE_OPTION == openResult ) {
         File file = new File(view.fileChooserWindow.selectedFile.toString())
         // let's calculate an unique id for the next mvc group
         String mvcId = file.path + System.currentTimeMillis()
         createMVCGroup("FilePanel", mvcId,
            [file: file, tabGroup: view.tabGroup, tabName: file.name, mvcId: mvcId])
      }
   }

   def quit = {
      app.shutdown()
   }
}
