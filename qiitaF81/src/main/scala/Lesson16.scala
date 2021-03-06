package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson16 {

  def main(args: Array[String]): Unit = {

    val domain1 = new Domain1(1, "田中")
    val domain2 = new Domain1(1, "田中")

    println(domain1 == domain2) // true
    println(domain1 != domain2) // false

    val domain3 = new Domain1(2, "山田")

    println("== : ", domain1 == domain3) // false
    println("!= : ", domain1 != domain3) // true


    val domain4 = domain1

    println(domain1.eq(domain2)) // false
    println(domain1.eq(domain4)) // true
    println(domain1.ne(domain4)) // false

  }

}
