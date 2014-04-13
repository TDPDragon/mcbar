package me.limito.mcbar.log

import org.bukkit.Bukkit
import java.util.logging.Level

object Log {
  private val log = Bukkit.getServer.getPluginManager.getPlugin("McBar").getLogger

  def info(message: String) {
    log.info(message)
  }

  def error(message: String, error: Exception) {
    log.log(Level.WARNING, message, error)
  }
}
