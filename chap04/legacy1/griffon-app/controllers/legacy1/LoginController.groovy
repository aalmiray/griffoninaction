package legacy1

import javax.swing.JOptionPane

class LoginController {
    def model
    def view

    def loginOk = { evt = null ->
        doLater {
            JOptionPane.showMessageDialog(view.mainFrame, """You entered the following information:
username: ${model.username}
password: ${model.password}
""".toString())
        }
    }

    def loginCancel = { evt = null ->
        doLater {
            JOptionPane.showMessageDialog(view.mainFrame, "You canceled the login dialog.")
        }
    }
}
