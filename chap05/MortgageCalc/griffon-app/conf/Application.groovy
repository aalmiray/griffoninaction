application {
    title='MortgageCalc'
    startupGroups = ['MortgageCalc']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "MortgageCalc"
    'MortgageCalc' {
        model = 'MortgageCalcModel'
        view = 'MortgageCalcView'
        controller = 'MortgageCalcController'
    }

}
