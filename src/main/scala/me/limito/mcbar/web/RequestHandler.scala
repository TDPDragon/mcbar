package me.limito.mcbar.web

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import javax.imageio.ImageIO
import me.limito.mcbar.generators.BarGeneratorRegistry
import me.limito.mcbar.data.PlayerId

class RequestHandler extends AbstractHandler {
  /** Handles /{bar name}/{username}.png */
  override def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
    val parts = target.split("/")
    parts match {
      case Array("", barname, fileName) => handle(barname, fileName, baseRequest, response)
      case _ =>
    }
  }

  def handle(barname: String, fileName: String, baseRequest: Request, response: HttpServletResponse) {
    val playerName = if (fileName.endsWith(".png")) fileName.substring(0, fileName.length - 4) else fileName
    val barGenerator = BarGeneratorRegistry.get(barname)

    if (barGenerator != null) {
      val image = barGenerator.generate(new PlayerId(playerName))
      response.setContentType("image/png")
      response.setStatus(HttpServletResponse.SC_OK)
      ImageIO.write(image, "PNG", response.getOutputStream)
    }
  }
}
