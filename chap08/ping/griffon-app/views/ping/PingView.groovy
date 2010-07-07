package ping

actions {
  action(id: "pingAction",
    name: "Ping!",
    closure: controller.doPing)
}

application(title: 'Ping',
  size: [200, 100],
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    gridLayout(cols: 1, rows: 3)
    button(pingAction)
    label(text: bind{ model.output })
    label(text: bind{ model.pongText })
}
