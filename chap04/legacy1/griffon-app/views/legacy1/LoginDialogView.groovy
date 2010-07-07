package legacy1

// create instance of view object
widget(new LoginDialog(mainFrame, true), id:'loginDialog')

noparent {
    // javax.swing.JTextField usernameField declared in LoginDialog
    bean(loginDialog.usernameField, id:'usernameField', text: bind(target: model, targetProperty: "username"))

    // javax.swing.JPasswordField passwordField declared in LoginDialog
    bean(loginDialog.passwordField, id:'passwordField', text: bind(target: model, targetProperty: "password"))

    // javax.swing.JButton okButton declared in LoginDialog
    bean(loginDialog.okButton, id:'okButton', actionPerformed: controller.loginOk)

    // javax.swing.JButton cancelButton declared in LoginDialog
    bean(loginDialog.cancelButton, id:'cancelButton', actionPerformed: controller.loginCancel)
}
return loginDialog
