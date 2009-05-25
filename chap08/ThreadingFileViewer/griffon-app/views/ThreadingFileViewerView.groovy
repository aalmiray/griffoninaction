import javax.swing.JTabbedPane

actions {
   action(id: "quitAction",
      name: "Quit",
      mnemonic: "Q",
      accelerator: shortcut("Q"),
      closure: controller.quit)
}

fileChooserWindow = fileChooser()
fileViewerWindow = application(title:'ThreadingFileViewer', size:[480,320], locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   menuBar {
      menu("File") {
         menuItem(quitAction)
      }
   }
   borderLayout()
   tabbedPane(id: "tabGroup", constraints: CENTER, tabPlacement: JTabbedPane.LEFT)
}