/**
  * Created by morikawakaori on 2017/01/07.
  */
object Lesson14 {

  def main(args: Array[String]): Unit = {

    val map = Map(1 -> "Mouse", 2 -> "Lucas", 3 -> "Henderson", 5 -> null)
    println(map.get(1)) // Some(Mouse)
    println(map.get(4)) // None
    println(map.get(5)) // Some(null)

    val person = map.get(2)
    println(person.get)


    def check(o: Option[String]): Unit = {
      o match {
        case Some(s) => println(s)
        case None => println("Not exist")
      }
    }

    check(map.get(1))
    check(map.get(4))
  }

}
