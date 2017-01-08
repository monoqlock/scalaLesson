package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
class Truck(color: String ) extends Car(color) {
  override def run: Unit = println("Truck Start!!")
}
