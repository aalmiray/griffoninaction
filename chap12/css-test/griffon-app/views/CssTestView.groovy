application(id: "mainFrame", title: 'css-test',
  pack: true, locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
  gridLayout(cols: 2, rows: 1)
  panel(name: "group1") {
      gridLayout(cols: 1, rows: 4)
      label("Label 1.1")
      label("Label 1.2")
      button("Button 1.1")
      button("Button 1.2", cssClass: "active")
  }
  panel(name: "group2") {
      gridLayout(cols: 1, rows: 4)
      label("Label 2.1")
      label("Label 2.2", cssClass: "active")
      button("Button 2.1")
      button("Button 2.2")
  }
}
