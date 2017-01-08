package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
class Domain1(val id: Long, val name: String) {

  def canEqual(other: Any) = {
    other.isInstanceOf[Domain1]
  }

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case that: Domain1 =>
        that.canEqual(Domain1.this) && id == that.id && name == that.name
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val prime = 41
    prime * (prime + id.hashCode) + name.hashCode
  }
}
