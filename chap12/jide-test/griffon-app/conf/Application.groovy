application {
    title = 'JideTest'
    startupGroups = ['jide-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "jide-test"
    'jide-test' {
        model = 'JideTestModel'
        controller = 'JideTestController'
        view = 'JideTestView'
    }

}
