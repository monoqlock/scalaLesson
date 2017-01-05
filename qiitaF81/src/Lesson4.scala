/**
  * Created by morikawakaori on 2017/01/03.
  */

class User(val id: Long, val firstName: String, val lastName: String, val fullName: FullName = new FullName) {
  def getFullName() = this.fullName.get(firstName, lastName)

}

class FullName() {
  def get(firstName: String, lastName: String) = firstName + " " + lastName
}

class FullNameInJapan() extends FullName {
  override def get(firstName: String, lastName: String): String = lastName + " " + firstName
}

//val user1 = new User(1, "太郎", "山田", new FullNameInJapan)
//println(user1.getFullName())
//
//val user2 = new User(2, "Taro", "Yamada")
//println(user2.getFullName())