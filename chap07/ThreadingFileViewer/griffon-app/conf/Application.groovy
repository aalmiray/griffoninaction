application {
    title = 'ThreadingFileViewer'
    startupGroups = ['ThreadingFileViewer']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    'ReadingTab' {
        model = 'threadingfileviewer.ReadingTabModel'
        controller = 'threadingfileviewer.ReadingTabController'
        view = 'threadingfileviewer.ReadingTabView'
    }
    'ThreadingFileViewer' {
        model = 'threadingfileviewer.ThreadingFileViewerModel'
        controller = 'threadingfileviewer.ThreadingFileViewerController'
        view = 'threadingfileviewer.ThreadingFileViewerView'
    }
}
