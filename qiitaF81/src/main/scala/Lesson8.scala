package main.scala

/**
  * Created by a13180 on 2017/01/06.
  */
object Lesson8 {

  def main(args: Array[String]): Unit = {
    val numbers = Set(1,2,3)
    println(numbers)

    // List
    println("----- List")
    val list = List(1,2,3)
    println(list)
    val list2 = 1 :: 2 :: 3 :: Nil
    println(list2)
    val list3 = 1 :: (2 :: (3 :: Nil))
    println(list3)
    println(list3.tail.head)
    println(list3.tail.tail.head)
    println(list3.tail.tail.isEmpty)
    println(list3.tail.tail.tail.isEmpty)

    // Set
    println("--------- Set")
    val set = Set(1, 2, 3)
    println(set.contains(3))
    println(set.contains(5))

    // Map
    println("---------- Map")
    val map = Map(1 -> "red", 2 -> "blue", 3 -> "black")
    println(map(1))
  }

}
