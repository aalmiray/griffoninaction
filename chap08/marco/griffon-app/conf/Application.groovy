application {
    title='Marco'
    startupGroups = ['marco']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "marco"
    'marco' {
        model = 'MarcoModel'
        controller = 'MarcoController'
        view = 'MarcoView'
    }

}
