application {
    title='GroovyEdit'
    startupGroups = ['GroovyEdit']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "FilePanel"
    'FilePanel' {
        model = 'FilePanelModel'
        view = 'FilePanelView'
        controller = 'FilePanelController'
    }

    // MVC Group for "GroovyEdit"
    'GroovyEdit' {
        model = 'GroovyEditModel'
        view = 'GroovyEditView'
        controller = 'GroovyEditController'
    }

}
