package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
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
