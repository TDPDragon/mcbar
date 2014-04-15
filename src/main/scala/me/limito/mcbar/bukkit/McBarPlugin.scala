package me.limito.mcbar.bukkit

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.command.{Command, CommandSender}
import java.io.File
import javax.imageio.ImageIO
import java.awt.Desktop
import me.limito.mcbar.web.WebServer
import me.limito.mcbar.dataprovider.{HeadProvider, MoneyProvider, DataProviderRegistry}
import me.limito.mcbar.generators.{SampleGenerator, BarGeneratorRegistry}
import me.limito.mcbar.data.PlayerId

class McBarPlugin extends JavaPlugin {
  var webServer: WebServer = _

  override def onEnable() {
    loadGenerators()
    loadProviders()
    initWebserver()
    webServer.start()
  }

  override def onDisable() {
    webServer.stop()
  }

  private def loadGenerators() {
    BarGeneratorRegistry.unregisterAll()
    BarGeneratorRegistry.register(new SampleGenerator)
  }

  private def loadProviders() {
    saveDefaultConfig()
    val skinUrl = getConfig.getString("skinUrl")

    DataProviderRegistry.register("money", new MoneyProvider)
    DataProviderRegistry.register("head", new HeadProvider(skinUrl))
  }

  private def initWebserver() {
    saveDefaultConfig()
    val webserverPort = getConfig.getInt("webserver-port")
    webServer = new WebServer(webserverPort)
  }
}
