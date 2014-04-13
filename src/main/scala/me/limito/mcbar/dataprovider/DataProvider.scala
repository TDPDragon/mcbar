package me.limito.mcbar.dataprovider

import me.limito.mcbar.data.PlayerId

abstract class DataProvider[T] {
  val name: String

  def get(player: PlayerId): T
}
