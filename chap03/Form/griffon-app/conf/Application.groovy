application {
    title = 'Form'
    startupGroups = ['form']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "form"
    'form' {
        model      = 'form.FormModel'
        view       = 'form.FormView'
        controller = 'form.FormController'
    }

}
