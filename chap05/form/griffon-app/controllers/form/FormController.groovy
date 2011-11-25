package form

import griffon.transform.Threading
import griffon.util.GriffonNameUtils as GNU

class FormController {
    def model

    def clear = {
            model.griffonClass.propertyNames.each { name ->
            model[name] = ''
        }
    }

    @Threading(Threading.Policy.SKIP)
    def submit = {
        javax.swing.JOptionPane.showMessageDialog(
            app.windowManager.windows.find{it.focused},
            model.griffonClass.propertyNames.collect([]) { name ->
                "${GNU.getNaturalName(name)} = ${model[name]}"
            }.join('\n')
        )
    }

    def quit = {
        app.shutdown()
    }
}
