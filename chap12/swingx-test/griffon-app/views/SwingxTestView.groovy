import java.awt.Color
import org.jdesktop.swingx.painter.GlossPainter

gloss = glossPainter(paint: new Color(1f, 1f, 1f, 0.2f),
    position: GlossPainter.GlossPosition.TOP)
stripes = pinstripePainter(paint: new Color(1f, 1f, 1f, 0.17f),
                           spacing: 5f)
matte = mattePainter(fillPaint: new Color(51, 51, 51))
compound = compoundPainter(painters: [matte, stripes, gloss])

application(title: 'swingx-test', pack: true, locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    jxheader(constraints: NORTH,
        title: "SwingXBuilder Example",
        description: "A brief example of SwingXBuilder in action",
        titleForeground: Color.WHITE, 
        descriptionForeground: Color.WHITE, 
        icon: imageIcon("/griffon-icon-48x48.png"),
        preferredSize: [480,80],
        backgroundPainter: compound
    )
    jxtaskPaneContainer(constraints: CENTER) {
        jxtaskPane(title: "Task group 1") {
            jxlabel("Action 1")
        }
        jxtaskPane(title: "Task group 2", collapsed: true) {
            label("Action 2")
        }
    }
}
