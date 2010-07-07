package threadingfileviewer

tabbedPane(tabGroup) {
   panel(title: "Test #"+index) {
      borderLayout()
      panel(constraints: NORTH) {
      gridLayout(cols: 1, rows: 2)
         label(testLabel)
         button("Choose a file...",
            enabled: bind{ model.enabled },
            actionPerformed: controller."$action")
      }
      scrollPane(constraints: CENTER) {
         textArea(id: "editor",
            editable: false,
            lineWrap: true,
            text: bind{ model.text },
            caretPosition: bind(source: model, sourceProperty: "text",
                                converter: {0} ))
      }
      progressBar(id: "progress",
         indeterminate: true,
         minimum:0, maximum: 100,
         constraints: SOUTH)
   }
}
