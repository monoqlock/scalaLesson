// Ex3_4
def drop[A](l: List[A], n: Int): List[A] = {
	if (n <= 0) l
	else l match {
		case Nil => Nil
		case Cons(_, t) => drop(t, n-1) 
	}
}