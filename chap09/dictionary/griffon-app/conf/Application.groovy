application {
    title = 'Dictionary'
    startupGroups = ['dictionary']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "dictionary"
    'dictionary' {
        model      = 'dictionary.DictionaryModel'
        view       = 'dictionary.DictionaryView'
        controller = 'dictionary.DictionaryController'
    }
}
