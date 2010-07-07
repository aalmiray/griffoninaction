package sample

application(title: 'sample',
  pack:true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   gridLayout(cols: 2, rows: 3)
   label 'A:'
   textField columns: 10, text: bind('inputA', target: model)
   label 'B:'
   textField columns: 10, text: bind('inputB', target: model)
   button 'Result ->', actionPerformed: controller.click, enabled: bind{ model.enabled }
   label text: bind{ model.output } 
}
