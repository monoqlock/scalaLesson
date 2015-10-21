object Ex3_2 {

	sealed trait ListTest[+A]
	// case object Nil extends ListTest[Nothing]
	case class Cons[+A](head: A, tail: ListTest[A]) extends ListTest[A]
	
	def tail[A](l: List[A]): List[A] = {
		 l match {
		 	case Nil => sys.error("tail of empty list")
		 	case Cons(_, t) => t
		 }
		 
	}

	def main(args: Array[String]): Unit = {
	  println(tail(List("a", "b")))
	}
	
}