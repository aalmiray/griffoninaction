dialog(owner: mainFrame,
  id: "loginDialog",
  resizable: false,
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    formPanel("login.xml")
    noparent {
        bean(model, username: bind{ usernameField.text })
        bean(model, password: bind{ passwordField.text })
        bean(okButton, actionPerformed: controller.loginOk)
        bean(cancelButton, actionPerformed: controller.loginCancel)
    }
}
