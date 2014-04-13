package me.limito.mcbar.dataprovider

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import scalaj.http.{HttpOptions, Http}
import java.io.ByteArrayInputStream
import me.limito.mcbar.data.{PlayerId, SkinPart}
import me.limito.mcbar.log.Log
import javax.servlet.http.HttpServletResponse

class HeadProvider(url: String) extends DataProvider[BufferedImage] {
  val name = "head"
  val defaultSkin = ImageIO.read(getClass.getResource("/char.png"))

  override def get(player: PlayerId): BufferedImage = {
    SkinPart.HEAD_FRONT.getPartImage(downloadSkin(player.name))
  }

  private def downloadSkin(name: String): BufferedImage = {
    try {
      val urlString: String = url + name + ".png"
      val http = Http(urlString).options(HttpOptions.connTimeout(5000), HttpOptions.readTimeout(5000))
      if (http.responseCode == HttpServletResponse.SC_OK) {
        val bytes = http.asBytes
        ImageIO.read(new ByteArrayInputStream(bytes))
      } else {
        defaultSkin
      }
    }
    catch {
      case ex: Exception => Log.error("Error loading skin for " + name, ex); defaultSkin
    }
  }
}
