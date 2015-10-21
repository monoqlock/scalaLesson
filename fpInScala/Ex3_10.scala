// Ex3_10
@annotation.tailrec
def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = {
	l match {
		case Nil => z
		case Cons(h, t) => foldLeft(t, f(z, h))(f)
	}
}

// Ex3_11
def sum3(l: List[Int]) = foldLeft(l, 0)(_ + _)
def product3(l: List[Double]) = foldLeft(l, 1.0)(_ * _)
def length2(l: List[A]): Int = foldLeft(l, 0)((acc,h) => acc + 1)

// Ex3_12
def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc, h) => Cons(h, acc))

// Ex 3_14
def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)(Cons(_, _))

