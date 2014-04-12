package me.limito.mcbar.bukkit

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.command.{Command, CommandSender}
import me.limito.mcbar.{BarGeneratorRegistry, PlayerId, SampleGenerator}
import java.io.File
import javax.imageio.ImageIO
import java.awt.Desktop
import me.limito.mcbar.web.WebServer

class McBarPlugin extends JavaPlugin {
  val webServer = new WebServer(8070)

  override def onEnable() {
    loadGenerators()
    webServer.start()
  }

  override def onDisable() {
    webServer.stop()
  }

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean = {
    sender.sendMessage("Lol")

    val gen = new SampleGenerator
    val file = File.createTempFile("bar", ".png")
    val image = gen.generate(new PlayerId(sender.getName))
    ImageIO.write(image, "PNG", file)
    Desktop.getDesktop.open(file)
    true
  }

  private def loadGenerators() {
    BarGeneratorRegistry.unregisterAll()
    BarGeneratorRegistry.register(new SampleGenerator)
  }
}
