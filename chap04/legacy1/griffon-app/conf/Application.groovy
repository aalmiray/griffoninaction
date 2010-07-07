application {
    title = 'Legacy1'
    startupGroups = ['legacy1']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "login"
    'login' {
        model = 'legacy1.LoginModel'
        controller = 'legacy1.LoginController'
        view = 'legacy1.LoginDialogView'
    }

    // MVC Group for "legacy1"
    'legacy1' {
        model = 'legacy1.Legacy1Model'
        controller = 'legacy1.Legacy1Controller'
        view = 'legacy1.Legacy1View'
    }
}
