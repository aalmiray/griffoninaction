application {
    title='Legacy1'
    startupGroups = ['legacy1']

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
        view = 'LoginDialogView'
    }

    // MVC Group for "legacy1"
    'legacy1' {
        model = 'Legacy1Model'
        controller = 'Legacy1Controller'
        view = 'Legacy1View'
    }
}
