import com.jidesoft.swing.ButtonStyle

application(title: 'jide-test', pack: true, locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   borderLayout()
   panel(border: titledBorder(title: "CheckBoxList"), constraints: WEST) {
      scrollPane(constraints: context.CENTER) {
          checkBoxList(listData: (1..20).collect([]){"Option $it"} as Object[])
      }
   }
   panel(border: titledBorder(title: "Buttons"), constraints: CENTER) {
      panel{
         gridLayout(cols: 1, rows: 5)
         ["Toolbar", "Toolbox", "Flat", "Hyperlink"].each { style ->
            jideButton(style,
               buttonStyle: ButtonStyle."${style.toUpperCase()}_STYLE")
         }
         jideSplitButton("Button + Menu",
            customize: { m ->
               m.removeAll()
               (1..2).each{ m.add "Option $it" }
            })
      }
   }
}
