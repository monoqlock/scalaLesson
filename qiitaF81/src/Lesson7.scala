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

object CaseClassTuple {

  def get() = {
    val name = new Name("太郎","山田")
    (Human(name, 15), name)
  }

  def main(args: Array[String]) = {
    val tuple = get()
    printf("fullname_1=%s \n", tuple._1.name.fullName)
    printf("fullname_2=%s \n", tuple._2.fullName)
  }
}

class Name(first: String, last: String) {
  def fullName() = first + " " + last
}

case class Human(name: Name, age: Int)


