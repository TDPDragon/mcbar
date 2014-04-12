package me.limito.mcbar

import java.awt.image.BufferedImage
import scala.util.Random
import java.awt.Color
import org.bukkit.Bukkit
import net.milkbowl.vault.economy.Economy

object BasicData {
  def money(implicit player: PlayerId): Double = {
    val rsp = Bukkit.getServer.getServicesManager.getRegistration(classOf[Economy])
    if (rsp != null) {
      val econ = rsp.getProvider
      econ.getBalance(player.name)
    } else {
      0
    }
  }

  def head(implicit player: PlayerId): BufferedImage = {
    val image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB_PRE)
    val g = image.createGraphics()
    val rgb = Random.nextInt(0x1000000)
    g.setColor(new Color(rgb))
    g.fillRect(0, 0, image.getWidth, image.getHeight)
    image
  }
}
