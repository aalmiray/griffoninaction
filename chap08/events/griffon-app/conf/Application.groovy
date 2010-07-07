application {
    title = 'Events'
    startupGroups = ['events']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "events"
    'events' {
        model = 'events.EventsModel'
        controller = 'events.EventsController'
        view = 'events.EventsView'
    }

}
