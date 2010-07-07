application {
    title = 'Legacy2'
    startupGroups = ['legacy2']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "login"
    'login' {
        model = 'legacy2.LoginModel'
        controller = 'legacy2.LoginController'
        view = 'legacy2.LoginView'
    }

    // MVC Group for "legacy2"
    'legacy2' {
        model = 'legacy2.Legacy2Model'
        controller = 'legacy2.Legacy2Controller'
        view = 'legacy2.Legacy2View'
    }

}
