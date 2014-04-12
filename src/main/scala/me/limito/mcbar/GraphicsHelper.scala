package me.limito.mcbar

import java.awt.image.BufferedImage
import java.awt.{Font, Color, Graphics2D}
import javax.imageio.ImageIO

object GraphicsHelper {
  def image(img: BufferedImage, x: Int, y: Int, w: Int, h: Int)(implicit g: Graphics2D) {
    if (img != null)
      g.drawImage(img, x, y, w, h, null)
  }

  def loadImage(path: String): BufferedImage = {
    val resource = getClass.getResource(path)
    ImageIO.read(resource)
  }

  def text(str: String, x: Int, y: Int, align: Align = Align.Left)(implicit g: Graphics2D) {
    if (str != null) {
      val width = g.getFontMetrics.stringWidth(str)
      g.drawString(str, (x - width * align.position).toInt, y)
    }
  }

  def color(rgb: Int)(implicit g: Graphics2D) {
      g.setColor(new Color(rgb))
  }

  def color(r: Int, g: Int, b: Int)(implicit gr: Graphics2D) {
    gr.setColor(new Color(r, g, b))
  }

  def systemFont(name: String, size: Int, style: Int = Font.PLAIN)(implicit gr: Graphics2D) {
    gr.setFont(new Font(name, style, size))
  }
}
