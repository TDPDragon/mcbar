package me.limito.mcbar.generators

import java.awt.image.BufferedImage
import java.awt.{Font, Color, Graphics2D}
import javax.imageio.ImageIO
import java.util
import java.util.Collections
import me.limito.mcbar.log.Log

object GraphicsHelper {
  private val fontCache = Collections.synchronizedMap(new util.HashMap[String, Font])
  private val defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12)

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

  def font(resource: String, size: Int)(implicit gr: Graphics2D) {
    val cachedFont = fontCache.get(resource)
    if (cachedFont == null) {
      gr.setFont(cachedFont.deriveFont(size))
    } else {
      val font = loadFont(resource)
      fontCache.put(resource, font)
      gr.setFont(font.deriveFont(size))
    }
  }

  def systemFont(name: String, size: Int, style: Int = Font.PLAIN)(implicit gr: Graphics2D) {
    gr.setFont(new Font(name, style, size))
  }

  private def loadFont(resource: String): Font = {
    val inputStream = getClass.getResourceAsStream(resource)
    try {
      Font.createFont(Font.TRUETYPE_FONT, inputStream)
    } catch {
      case ex: Exception => Log.error(s"Error loading font from $resource", ex); defaultFont
    } finally {
      inputStream.close()
    }
  }
}
