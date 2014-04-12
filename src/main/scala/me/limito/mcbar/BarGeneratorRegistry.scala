package me.limito.mcbar

import scala.collection.mutable

object BarGeneratorRegistry {
  private var map = mutable.Map[String, BarGenerator]()

  def register(generator: BarGenerator) {
    require(generator.name != null)
    map += (generator.name -> generator)
  }

  def unregisterAll() {
    map = mutable.Map[String, BarGenerator]()
  }

  def get(name: String) = map.getOrElse(name, null)
}
