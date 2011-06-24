package form

import griffon.transform.Threading

class FormController {
    def model
    def view

    @Threading(Threading.Policy.SKIP)
    def reset = {
        model.name = ''
        model.lastName = ''
        model.address = ''
    }

    def submit = {
        println "Name: ${model.name}"
        println "Last Name: ${model.lastName}"
        println "Address: ${model.address}"
    }
}
