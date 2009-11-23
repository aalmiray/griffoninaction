application {
	title="MortgageCalc"
	startupGroups=["MortgageCalc"]
	autoShutdown=true
}
mvcGroups {
	MortgageCalc {
		model="MortgageCalcModel"
		controller="MortgageCalcController"
		view="MortgageCalcView"
	}
}
