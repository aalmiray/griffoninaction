application {
    title = 'FileViewer'
    startupGroups = ['fileViewer']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "FileViewer"
    'fileViewer' {
        model      = 'fileviewer.FileViewerModel'
        view       = 'fileviewer.FileViewerView'
        controller = 'fileviewer.FileViewerController'
    }
}
