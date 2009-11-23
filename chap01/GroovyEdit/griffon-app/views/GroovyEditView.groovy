actions {
   action(id: "openAction",
      name: "Open",
      mnemonic: "O",
      accelerator: shortcut("0"),
      closure: controller.openFile)
   action(id: "quitAction",
      name: "Quit",
      mnemonic: "Q",
      accelerator: shortcut("Q"),
      closure: controller.quit)
}

fileChooserWindow = fileChooser()
fileViewerWindow = application(title:'GroovyEdit', size:[480,320], locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image] ) {
   menuBar {
      menu("File") {
         menuItem(openAction)
         separator()
         menuItem(quitAction)
      }
   }
   borderLayout()
   tabbedPane(id: "tabGroup", constraints: CENTER)
}
