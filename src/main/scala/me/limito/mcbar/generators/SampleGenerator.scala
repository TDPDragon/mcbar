package me.limito.mcbar.generators

import java.awt.{Font, Graphics2D}
import GraphicsHelper._
import BasicData._
import me.limito.mcbar.data.PlayerId

class SampleGenerator extends BarGenerator {
  override val size: Size = Size(320, 64)
  override val name: String = "samplebar"

  val background = loadImage("/samplebar/bg.png")

  override def generate(implicit player: PlayerId, g: Graphics2D) {
    image(background, 0, 0, size.width, size.height)
    image(head, 15, 15, 32, 32)

    systemFont("Sans", 18)
    color(255, 255, 0)
    text(player.name, 57, 28)

    color(255, 255, 255)
    text(money + "$", 75, 52)
  }
}
