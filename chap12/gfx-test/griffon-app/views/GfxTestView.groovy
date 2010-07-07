application(title: 'gfx-test', pack: true, locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]){
   canvas(preferredSize: [300, 300]) {
      group {
         antialias true
         background(color: color(r: 0.6, g: 0.9, b:0.8))
         rect(y: 230, w: 300, h: 70, f: color(g: 0.8), bc: color(g:0.5)) {
            wobbleStroke()
         }
         rect(x: 75, y: 150, w: 150, h: 100, f: 'white')
         triangle(x: 55, y: 150, w: 190, h: 50, f: 'red')
         rect(x: 130, y: 190, w: 40, h: 60, f: 'brown')
         circle(cx: 50, cy: 50, r: 30, f: 'yellow', bc: 'red') 
      }
   }
}
