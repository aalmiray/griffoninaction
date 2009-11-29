actions {
   action(id: "loginAction",
      name: "Login",
      closure: controller.login)
   action(id: "exitAction",
      name: "Exit",
      closure: controller.exit)
}

mainFrame = application(title: 'My Legacy Application',
  size:[400, 200],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   menuBar {
      menu("File") {
         menuItem(loginAction)
         separator()
         menuItem(exitAction)
      }
   }
}
