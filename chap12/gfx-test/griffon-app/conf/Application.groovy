application {
    title='GfxTest'
    startupGroups = ['gfx-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "gfx-test"
    'gfx-test' {
        model = 'GfxTestModel'
        controller = 'GfxTestController'
        view = 'GfxTestView'
    }

}
