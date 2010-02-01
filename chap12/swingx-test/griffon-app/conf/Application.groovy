application {
    title='SwingxTest'
    startupGroups = ['swingx-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "swingx-test"
    'swingx-test' {
        model = 'SwingxTestModel'
        controller = 'SwingxTestController'
        view = 'SwingxTestView'
    }

}
