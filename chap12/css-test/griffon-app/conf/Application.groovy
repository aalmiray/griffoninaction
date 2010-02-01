application {
    title='CssTest'
    startupGroups = ['css-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "css-test"
    'css-test' {
        model = 'CssTestModel'
        controller = 'CssTestController'
        view = 'CssTestView'
    }

}
