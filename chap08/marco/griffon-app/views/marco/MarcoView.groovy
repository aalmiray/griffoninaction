package marco

actions {
    action(id: "marcoAction",
        name: "Marco!",
        closure: controller.marco)
}

application(title: 'Marco! ... Polo!',
  size:[300,160],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    button(marcoAction, constraints: NORTH)
    scrollPane(constraints: CENTER) {
        textArea(text: bind { model.output })
    }
}
