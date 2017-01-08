package main.scala

/**
  * Created by morikawakaori on 2017/01/03.
  */
object Lesson3 {

  def main(args: Array[String]): Unit = {

    val candidates = List(1,2,3,4)

    val filter = (predicate : Int => Boolean) => {
      (candidates: List[Int]) => {
        for (x <- candidates; if predicate(x)) yield x
      }
    }

    val predicate = (x: Int) => x % 2 == 0

    val oddFilter = filter(predicate)
    oddFilter(candidates).foreach(println)
  }

}
