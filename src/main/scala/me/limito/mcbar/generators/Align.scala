package me.limito.mcbar.generators

case class Align(position: Double)
object Align {
  val Left = Align(0)
  val Center = Align(0.5)
  val Right = Align(1)
}
