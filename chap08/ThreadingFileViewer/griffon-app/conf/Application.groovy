application {
    title='ThreadingFileViewer'
    startupGroups = ['ThreadingFileViewer']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "ReadingTab"
    'ReadingTab' {
        model = 'ReadingTabModel'
        view = 'ReadingTabView'
        controller = 'ReadingTabController'
    }

    // MVC Group for "ThreadingFileViewer"
    'ThreadingFileViewer' {
        model = 'ThreadingFileViewerModel'
        view = 'ThreadingFileViewerView'
        controller = 'ThreadingFileViewerController'
    }
}
