package me.limito.mcbar.generators

case class Size(width: Int, height: Int) {
  require(width >= 0)
  require(height >= 0)
}
