application {
    title='Services'
    startupGroups = ['services']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "services"
    'services' {
        model = 'ServicesModel'
        controller = 'ServicesController'
        view = 'ServicesView'
    }

}

griffon.basic_injection.disable = true
