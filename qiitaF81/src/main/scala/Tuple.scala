package main.scala

/**
  * Created by a13180 on 2017/01/05.
  */
object Tuple {

  def getMaxValue(numbers: List[Int]) = {
    val max = numbers.max
    val index = numbers.indexOf(max)
    (max, index)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 10, 6)

    val maxValue = getMaxValue(numbers)
    printf("max :%s \n", maxValue._1)
    printf("index :%s ", maxValue._2)
  }

}
