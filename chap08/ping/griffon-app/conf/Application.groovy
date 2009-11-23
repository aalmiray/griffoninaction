application {
    title='Ping'
    startupGroups = ['ping']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "pong"
    'pong' {
        model = 'PongModel'
        controller = 'PongController'
        view = 'PongView'
    }

    // MVC Group for "ping"
    'ping' {
        model = 'PingModel'
        controller = 'PingController'
        view = 'PingView'
    }

}
