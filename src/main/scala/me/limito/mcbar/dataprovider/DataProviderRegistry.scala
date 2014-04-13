package me.limito.mcbar.dataprovider

import scala.collection.mutable

object DataProviderRegistry {
  private var map = mutable.Map[String, DataProvider[_]]()

  def register(name: String, dataProvider: DataProvider[_]) {
    require(name != null)
    require(dataProvider != null)

    map += (name -> dataProvider)
  }

  def unregisterAll() {
    map = mutable.Map[String, DataProvider[_]]()
  }

  def get[T](name: String) = map.getOrElse(name, null).asInstanceOf[DataProvider[T]]
}
