application {
	title="GroovyEdit"
	startupGroups=["GroovyEdit"]
	autoShutdown=true
}
mvcGroups {
	FilePanel {
		model="FilePanelModel"
		controller="FilePanelController"
		view="FilePanelView"
	}
	GroovyEdit {
		model="GroovyEditModel"
		controller="GroovyEditController"
		view="GroovyEditView"
	}
}
