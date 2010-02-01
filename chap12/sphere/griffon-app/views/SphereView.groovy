application(title:'sphere', pack: true, locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   canvas(preferredSize: [250, 250]) {
      group {
         antialias true
         background(color: color('white'))
         customNode(SphereNode, cx: 125, cy: 125)
      }
   }
}
