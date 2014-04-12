package me.limito.mcbar

import BasicData._
import GraphicsHelper._
import java.awt.Graphics2D

class SampleGenerator extends BarGenerator {
  override val size: Size = Size(300, 50)
  override val name: String = "samplegen"

  val background = loadImage("/background.png")

  override def generate(implicit player: PlayerId, g: Graphics2D) {
    image(background, 0, 0, size.width, size.height)
    image(head, 10, 10, 50, 50)
    text(player.name, 10, 30)
    text(money + "$", 10, 10)
  }
}
