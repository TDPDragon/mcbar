package me.limito.mcbar.web

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.HandlerList

class WebServer(port: Int) {
  var server = {
    val s = new Server(port)
    val handlers = new HandlerList()
    handlers.addHandler(new RequestHandler)
    s.setHandler(handlers)
    s
  }

  def start() {
    server.start()
  }

  def stop() {
    server.stop()
  }
}
