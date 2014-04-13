package me.limito.mcbar.generators

import java.awt.image.BufferedImage
import me.limito.mcbar.data.{PlayerId, Money}
import me.limito.mcbar.dataprovider.DataProviderRegistry

object BasicData {
  def money(implicit player: PlayerId): Double = DataProviderRegistry.get[Money]("money").get(player).amount

  def head(implicit player: PlayerId): BufferedImage = DataProviderRegistry.get[BufferedImage]("head").get(player)
}
