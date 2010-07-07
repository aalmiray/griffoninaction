application {
    title = 'Ping'
    startupGroups = ['ping']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "pong"
    'pong' {
        model = 'ping.PongModel'
        controller = 'ping.PongController'
        view = 'ping.PongView'
    }

    // MVC Group for "ping"
    'ping' {
        model = 'ping.PingModel'
        controller = 'ping.PingController'
        view = 'ping.PingView'
    }
}
