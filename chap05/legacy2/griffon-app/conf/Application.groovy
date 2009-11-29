application {
    title='Legacy2'
    startupGroups = ['legacy2']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "login"
    'login' {
        model = 'LoginModel'
        controller = 'LoginController'
        view = 'LoginView'
    }

    // MVC Group for "legacy2"
    'legacy2' {
        model = 'Legacy2Model'
        controller = 'Legacy2Controller'
        view = 'Legacy2View'
    }

}
