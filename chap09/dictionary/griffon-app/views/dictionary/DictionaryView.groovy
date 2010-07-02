package dictionary

actions {
    action(id: 'searchAction',
        name: 'Search',
        closure: controller.findDefinition,
        enabled: bind {model.enabled})
}

application(title: 'Dictionary',
  pack: true, resizable: false, locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill')
    label 'Search term:', constraints: 'left'
    textField name: 'word', columns: 20, text: bind('word', target: model), constraints: 'wrap'
    button searchAction, name: 'search', constraints: 'span 2, right, wrap'
    scrollPane(constraints: 'span 2') {
        textArea name: 'result', editable: false, lineWrap: true, wrapStyleWord: true,
                 columns: 28, rows: 5, text: bind {model.result}
    }
}
