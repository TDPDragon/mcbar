package me.limito.mcbar

case class Size(width: Int, height: Int) {
  require(width >= 0)
  require(height >= 0)
}
