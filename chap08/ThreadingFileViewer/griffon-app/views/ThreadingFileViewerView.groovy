import javax.swing.JTabbedPane

actions {
   action(id: "quitAction",
      name: "Quit",
      mnemonic: "Q",
      accelerator: shortcut("Q"),
      closure: controller.quit)
}

fileChooserWindow = fileChooser()
fileViewerWindow = application(title:'ThreadingFileViewer', size:[480,320], locationByPlatform:true) {
   menuBar {
      menu("File") {
         menuItem(quitAction)
      }
   }
   borderLayout()
   tabbedPane(id: "tabGroup", constraints: CENTER, tabPlacement: JTabbedPane.LEFT)
}