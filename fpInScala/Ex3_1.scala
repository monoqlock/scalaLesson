sealed trait ListTest[+A]
case object Nil extends ListTest[Nothing]
case class Cons[+A](head: A, tail: ListTest[A]) extends ListTest[A]

object ListTest {
	def sum(ints: ListTest[Int]): Int = ints match {
		case Nil => 0
		case Cons(x, xs) => x + sum(xs) 
	}

	def product(ds: ListTest[Double]): Double = ds match {
		case Nil => 1.0
		case Cons(0.0, _) => 0.0
		case Cons(x, xs) => x * product(xs)
	}
	
	def apply[A](as: A*): ListTest[A] = {
		if (as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*))
	}

	def main(args: Array[String]): Unit = {
	  println("aaa")
	}	
	
}

object Ex3_1 {

	val x = ListTest(1, 2, 3, 4, 5) match {
		case Cons(x, Cons(2, Cons(4, _))) => x
		case Nil => 42
		case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => y
		// case Cons(h, t) => h + sum(t)
		case _ => 101
	}
	

	def main(args: Array[String]): Unit = {
	  println(x)
	}	
}