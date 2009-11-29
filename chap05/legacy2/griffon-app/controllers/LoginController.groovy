import javax.swing.JOptionPane

class LoginController {
    def model
    def view

    def loginOk = { evt = null ->
        view.loginDialog.with {
            visible = false
            dispose()
        }
        doLater {
            JOptionPane.showMessageDialog(view.mainFrame, """You entered the following information:
username: ${model.username}
password: ${model.password}
""".toString())
        }
    }

    def loginCancel = { evt = null ->
        view.loginDialog.with {
            visible = false
            dispose()
        }
        doLater {
            JOptionPane.showMessageDialog(view.mainFrame, "You canceled the login dialog.")
        }
    }
}
