package bookclient

makeTableTab = { params ->
  scrollPane(title: params.title) {
    table {
      def tableFormat = defaultTableFormat(columnNames: params.columns)
      eventTableModel(source: params.source, format: tableFormat)
      installTableComparatorChooser(source: params.source)
    }
  }
}

application(title: 'Bookclient', size: [480, 300],
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
  tabbedPane {
    makeTableTab(title: 'Authors', columns: ['Name', 'Lastname'],
                 source: model.authors)
    makeTableTab(title: 'Books', columns: ['Title'],
                 source: model.books)
    busyComponent(busy: bind{ model.busy }, title: 'Search') {
      panel {
        migLayout(layoutConstraints: 'fill')
        textField(columns: 30, text: bind('query', target: model))
        button('Search', actionPerformed: controller.search,
               enabled: bind{ model.enabled }, constraints: 'wrap')
        buttonGroup(id: 'choice')
        radioButton('Authors', buttonGroup: choice, selected: true,
                    actionCommand: BookclientModel.AUTHORS, constraints: 'wrap')
        radioButton('Books', buttonGroup: choice,
                    actionCommand: BookclientModel.BOOKS, constraints: 'wrap')
        label(text: bind{ model.status }, constraints: 'span 2, center, wrap')
        scrollPane(constraints: 'span 2, growx, growy' ) {
          table {
            def tableFormat = defaultTableFormat(columnNames: ['Title', 'Name', 'Lastname'])
            eventTableModel(source: model.results, format: tableFormat)
            installTableComparatorChooser(source: model.results)
          }
        }
      }
    }
  }
}
