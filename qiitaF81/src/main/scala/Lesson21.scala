
/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson21 {

  def main(args: Array[String]): Unit = {

    val stringTypeParam = new TypeParam[String]("test")
    println(stringTypeParam.get)

    val intTypeParam = new TypeParam[Int](3)
    println(intTypeParam.get)


    class School[A <: Person]
    val sc = new School[Student]
    val sc2 = new School[Person]

    class School2[A >: Person]
    val sc3 = new School2[Person]
    val sc4 = new School2[Animal]

    class School3[A >: Student <: Animal]
    val sc5 = new School3[Animal]
    val sc6 = new School3[Person]
    val sc7 = new School3[Student]

    // 共変
    class School4[+T]
    def receive(args: School4[Person]) = println("Success!!")
    receive(new School4[Person]) // OK
    receive(new School4[Student]) // OK
//    receive(new School4[Animal]) // NG

    // 反変
    class School5[-T]
    def receive2(args: School5[Person]) = println("Success!!")
    receive2(new School5[Person]) //OK
    receive2(new School5[Animal]) //OK
//    receive2(new School5[Student]) //NG

    // 非変
    class School6[T]
    def receive3(args: School6[Person]) = println("Success!!")
    receive3(new School6[Person]) //OK
//    receive3(new School6[Animal]) //NG
    //receive3(new School6[Student]) //NG

  }


  class TypeParam[T](val t: T) {
    def get: T = this.t
  }


  class Animal
  class Person extends Animal
  class Student extends Person


}
