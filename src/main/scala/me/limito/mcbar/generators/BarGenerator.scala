package me.limito.mcbar.generators

import java.awt.{RenderingHints, Graphics2D}
import java.awt.image.BufferedImage
import me.limito.mcbar.data.PlayerId

abstract class BarGenerator {
  val name: String
  val size: Size

  def generate(implicit player: PlayerId, g: Graphics2D)
  def generate(player: PlayerId): BufferedImage = {
    val image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB_PRE)
    val graphics = image.createGraphics()
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
    generate(player, graphics)
    graphics.dispose()
    image
  }
}
