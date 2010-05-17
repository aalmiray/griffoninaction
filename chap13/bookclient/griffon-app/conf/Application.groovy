application {
    title='Bookclient'
    startupGroups = ['bookclient']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "bookclient"
    'bookclient' {
        model = 'BookclientModel'
        controller = 'BookclientController'
        view = 'BookclientView'
    }

}

griffon.rest.injectInto = ["controller"]
