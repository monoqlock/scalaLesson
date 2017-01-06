/**
  * Created by a13180 on 2017/01/06.
  */
object Lesson9 {

  def main(args: Array[String]): Unit = {

    val job = new Job { val name = "student"}
    println(job.name)
    println(job.getName())

    val man = new Man
    println(man.sayName())
  }

}

trait Job {
  val name: String
  def getName() = {
    "My job is " + name
  }
}

trait Human1 {
  val name = "飛行帽"
  def sayName() = {
    println("My name is " + name)
  }
}

class Man extends Human1

