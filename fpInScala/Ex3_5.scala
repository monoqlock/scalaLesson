// Ex3_5
def dropwhile[A](l: List[A], f: A => Boolean): List[A] = {
	l match {
		case Cons(h, t) if f(h) => dropwhile(t, f)
		case _ => l 
	}
}