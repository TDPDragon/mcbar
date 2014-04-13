package me.limito.mcbar.data

import java.awt._
import java.awt.image.BufferedImage

object SkinPart {
  var BODY_FRONT: SkinPart = new SkinPart(5, 4, 2, 4)
  var HEAD_FRONT: SkinPart = new SkinPart(2, 2, 2, 2)
  var HEAD_LAYER_FRONT: SkinPart = new SkinPart(10, 2, 2, 2)
  var ARM_FRONT: SkinPart = new SkinPart(11, 5, 1, 3)
  var LEG_FRONT: SkinPart = new SkinPart(1, 5, 1, 3)
}

class SkinPart(tileX: Int, tileY: Int, width: Int, height: Int) {
  def getPartImage(skin: BufferedImage): BufferedImage = {
    val tileSizeX: Int = skin.getWidth / 16
    val tileSizeY: Int = skin.getHeight / 8
    val x: Int = tileSizeX * tileX
    val y: Int = tileSizeY * tileY
    val w: Int = width * tileSizeX
    val h: Int = height * tileSizeY
    val newImage: BufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB_PRE)
    val g2: Graphics2D = newImage.createGraphics
    g2.drawImage(skin, -x, -y, null)
    g2.dispose()
    newImage
  }
}

