import java.awt.Color
import griffon.builder.gfx.Colors
import griffon.builder.gfx.GfxBuilder
import griffon.builder.gfx.GfxAttribute
import griffon.builder.gfx.DrawableNode
import griffon.builder.gfx.CustomGfxNode

class SphereNode extends CustomGfxNode {
  @GfxAttribute(alias="r") double radius = 90
  @GfxAttribute double cx = 100
  @GfxAttribute double cy = 100
  @GfxAttribute Color base     = Colors.get("blue")
  @GfxAttribute Color ambient  = Colors.get(red: 6, green: 76, blue: 160, alpha: 127)
  @GfxAttribute Color specular = Colors.get(r: 64, g: 142, b: 203, a: 255)
  @GfxAttribute Color shine    = Colors.get("white")

  SphereNode() {
    super("sphere")
  }

  DrawableNode createNode(GfxBuilder builder) {
    double height = radius * 2
    builder.group(borderColor: 'none') {
      // shadow
      circle(cx: cx, cy: cy+radius, radius: radius, sy: 0.3, sx: 1.2) {
        radialGradient {
          stop(offset: 0.0f, color: color('black'))
          stop(offset: 0.6f, color: color('black').derive(alpha: 0.5))
          stop(offset: 0.9f, color: color('black').derive(alpha: 0))
        }
      }
      // sphere
      circle(cx: cx, cy: cy, radius: radius) {
        multiPaint {
          colorPaint(color: base)
          radialGradient(radius: radius) {
            stop(offset: 0.0f, color: ambient)
            stop(offset: 1.0f, color: rgba(alpha: 204))
          }
          radialGradient(cy: cy + (height*0.9),
                         fy: cy + (height*1.1)+20,
                         radius: radius) {
            stop(offset: 0.0f, color: specular)
            stop(offset: 0.8f, color: specular.derive(alpha: 0))
            // transforms{ scale(y: 0.5) }
          }
          radialGradient(fit: false, radius: height/1.4,
                         fx: radius/2, fy: radius/4){
            stop(offset: 0.0f, color: shine.derive(alpha:0.5))
            stop(offset: 0.5f, color: shine.derive(alpha:0))
          }
        }
      }
    }
  }
}
