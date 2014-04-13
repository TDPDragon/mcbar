package me.limito.mcbar.dataprovider

import me.limito.mcbar.data.{PlayerId, Money}
import org.bukkit.Bukkit
import net.milkbowl.vault.economy.Economy

class MoneyProvider extends DataProvider[Money] {
  val name = "money"

  override def get(player: PlayerId): Money = {
    val rsp = Bukkit.getServer.getServicesManager.getRegistration(classOf[Economy])
    if (rsp != null) {
      val econ = rsp.getProvider
      Money(econ.getBalance(player.name))
    } else {
      Money(0)
    }
  }
}
