package fileviewer
import javax.swing.JTabbedPane

def makeTab = { heading, loadTechnique, technique ->
  panel {
    borderLayout()
    panel(constraints: NORTH) {
    gridLayout(cols: 1, rows: 2)
      label(heading)
      button("Choose a file...",
        enabled: bind{ technique.enabled },
        actionPerformed: loadTechnique)
    }
    scrollPane(constraints: CENTER) {
      textArea(id: "editor",
        editable: false,
        lineWrap: true,
        text: bind{ technique.text },
        caretPosition: bind(source: technique, sourceProperty: "text", converter: {0}))
    }
    technique.progress = progressBar(indeterminate: true,
      minimum:0, maximum: 100,
      constraints: SOUTH)
  }
}

actions {
  action(id: "quitAction",
    name: "Quit",
    mnemonic: "Q",
    accelerator: shortcut("Q"),
    closure: controller.quit)
}

fileChooser = fileChooser()
mainWindow = application(title:'FileViewer', size: [480,320], locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image] ) {
  menuBar {
    menu("File") {
       menuItem(quitAction)
    }
  }
  borderLayout()
  tabbedPane(constraints: CENTER, tabPlacement: JTabbedPane.LEFT) {
    [[heading: "No threading", action: "readFileNoThreading"],
     [heading: "Threading - doOutside/doLater", action: "readFileWithThreading"],
     [heading: "Threading - withWorker", action: "readFileWithWorker"],
     [heading: "Threading - progress update", action: "readFileWithUpdates"]].eachWithIndex { entry, index ->
       index += 1
       def loadTechnique = controller."${entry.action}"
       def technique = model."technique$index"
       widget(title: "Test #"+index, makeTab(entry.heading, loadTechnique, technique))
    }
  }
}
