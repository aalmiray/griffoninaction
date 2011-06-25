package form

application(title: 'form',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
  borderLayout()
  panel(constraints: CENTER, border: emptyBorder(6)) {
    gridLayout(rows:3, columns:2, hgap:6, vgap:6)
    label 'Name:'
    textField columns:20, 
	  text: bind(target: model, 'name', mutual: true)
    label 'Last Name:'
    textField columns:20, 
	  text: bind(target: model, 'lastName', mutual: true)
    label 'Address:'
    textField columns:20, 
	  text: bind(target: model, 'address', mutual: true)
  }
  panel(constraints: SOUTH) {
    gridLayout(rows:1, cols: 2, hgap:6, vgap:6)
    button('Reset', actionPerformed: controller.reset,
           enabled: bind{ model.resetEnabled })
    button('Submit', actionPerformed: controller.submit,
           enabled: bind{ model.submitEnabled })
  }
}
