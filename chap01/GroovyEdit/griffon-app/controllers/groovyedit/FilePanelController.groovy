package groovyedit

class FilePanelController {
   def model
   def view

   void mvcGroupInit(Map args) {
      model.loadedFile = args.file
      model.mvcId = args.mvcId
      doOutside {
         // load the file's text, outside the EDT
         String text = model.loadedFile.text
         // update the model inside the EDT
         doLater { model.fileText = text }
      }
   }

   def saveFile = {
      doOutside {
         // write text to file, outside the EDT
         model.loadedFile.text = view.editor.text
         // update model.text, inside EDT
         doLater { model.fileText = view.editor.text }
      }
   }

   def closeFile = {
      // remove tab
      view.tabGroup.remove view.tab
      // cleanup
      destroyMVCGroup model.mvcId
   }
}
