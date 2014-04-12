package me.limito.mcbar

import java.awt.Graphics2D
import java.awt.image.BufferedImage

abstract class BarGenerator {
  val name: String
  val size: Size

  def generate(implicit player: PlayerId, g: Graphics2D)
  def generate(player: PlayerId): BufferedImage = {
    val image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB_PRE)
    val graphics = image.createGraphics()
    generate(player, graphics)
    image
  }
}
