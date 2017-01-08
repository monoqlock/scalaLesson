import scala.util.Random

/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson18 {

  def main(args: Array[String]): Unit = {

    val random = Random.nextBoolean()

    val num = random match {
      case true => 1
      case false => 0
    }

    println("random: " + random)
    println("num: " + num)

    val list = List(1, true, "a", 'B')
    for (value <- list) {
      value match {
        case num: Integer => println("Integer: " + num)
        case bool: Boolean => println("Boolean: " + bool)
        case str: String => println("String: " + str)
        case _ => println("other: " + value)
      }
    }

    val num2 = 4
    val result = num2 match {
      case n => n * 2
    }
    println(result)

    val seq = Seq(1, 2, 3, 4)
    val result2 = seq match {
      case Seq(1, a, _*) => a
      case _ => 0
    }
    println("number: " + result2)

    val tuple = (1, 2, "OK")
    val result3 = tuple match {
      case (1, 2, x) => x
      case _ => "NG"
    }
    println("result3: " + result3)

    val person = Person("田中太郎", 20, "塾")
    val belongTo = person match {
      case Person("山田太郎", _ , "塾") => "山田塾"
      case Person("田中太郎", _ , "塾") => "田中塾"
      case _ => "一般"
    }
    println(belongTo)

  }

  case class Person(name: String, age: Int, education: String)

}
