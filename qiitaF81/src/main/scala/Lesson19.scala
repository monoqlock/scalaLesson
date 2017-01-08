package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson19 {

  def main(args: Array[String]): Unit = {

    def addCurried(x: Int)(y: Int)(z: Int) = x + y + z
    println(addCurried(2)(3)(4)) // 9

    def addPartical(x: Int, y: Int, z: Int) = x + y + z
    val addParticalWithX = addPartical(_:Int, _: Int, 5)
    println(addParticalWithX(1, 2)) // 8

  }

}
