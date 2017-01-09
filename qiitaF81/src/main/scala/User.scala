
/**
  * Created by morikawakaori on 2017/01/09.
  */


object User {

//  def unapply(user: User) = Option((user.firstname, user.lastname))

  def main(args: Array[String]): Unit = {
//    val user = new User("剛次", "赤石")
//
//    user match {
//      case User(firstname, lastname) => println(lastname + " " + firstname)
//      case _ => println("Not user.")
//    }
//
//    val User(firstName, lastName) = user
//    println(firstName + " " + lastName)

    val seq = Seq(1, 2, 3, 4)
    val Seq(x, y, _*) = seq
    printf("x: %s, y: %s", x, y)
  }

}

//class User(private val firstname: String, private val lastname: String)