trait Stream[A+];
case object Empty extends Stram[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
	def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
		lazy val head = hd
		lazy val tail = tl
		Cons(() => head, () => tail)
	}

	def empty[A]: Stream[A] = Empty

	def apply[A](as: A*): Stream[A] = {
		if (as.isEmpty) empty
		else cons(as.head, apply(as.tail: _*))
	}
}

// Ex5_1
def toListRecoursive: List[A] = {
	this match {
		case Cons(h, t) => h() :: t().toListRecoursive
		case _ => List() 
	}
}

def toList: List[A] = {
	@annotation.tailrec
	def go(s: Stream[A], acc: List[A]): List[A] = s.match {
		case Cons(h, t) => go(t(), h() :: acc)
		case _ => acc
	}
	go(this, List()).reverse
}

def toListFast: List[A] = {
	@annotation.tailrec
	def go(s: Stream[A]): List[A] = s.match {
		case Cons(h, t) =>
		 buf += h()
		 go(t())
	  case _ => buf.toList 
	}
	go(this)
}

// Ex5_2
def take(n: Int): Stream[A] = {
	this match {
		case Cons(h, t) if n > 1 => cons(h(), t().take(n-1))
		case Cons(h, _) if n == 1 => cons(h(), empty)
		case _ => empty 
	}
}

@annotaion.tailrec
final def drop(n: Int): Stream[A] = {
	this match {
		case Cons(_, t) if n > 0 => t().drop(n - 1)
		case _ => this 
	}
}

// Ex5_3
def takeWhile(p: A => Boolean): Stream[A] = {
	match {
		case Cons(h, t) if f(h()) => Cons(h(), t() takeWhile f)
 　　case _ => empty
	}
}

def exists(p: A => Boolean): Boolean = {
	this match {
		case Cons(h(), t()) => p(h()) || t().exists(p)
		case _ => false
	}
}

def foldRight[B](z: => B)(f: (A, => B) => B): B = {
	this match {
		case Cons(h, t) => f(h(), t().foldRight(z)(f))
		case _ => z
	}
}

// Ex5_4
def forAll(p: A => Boolean): Booleam = {
	foldRight(true)((a, b) => f(a) && b)
}

// Ex5_5
def takeWhile_1(f: A => Boolean): Stream[A] = {
  foldRight(empty[A])((h, t) =>
  	if (f(h)) cons(h, t)
  	else empty
  	)
}

// Ex5_6
def headOption: Option[A] = {
	foldRight(None: Option[A])((h,_) => Some(h))
}

// Ex5_7
def map[B](f: A => B): Stream[B] = {
	foldRight(empty[B])((h,t) => cons(f(h), t))
}

def filter(f: A => Boolean) :Stram[A] = {
	foldRight(empty[A])((h, t) =>
		if (f(h)) cons(h, t)
		else t)
}

def append[B:>A](s: => Stream[B]): Stream[B] = 
foldRight(s)((h,t) => cons(h,t))

def flatMap[B](f: A=> Stream[B]): Stream[B] = {
	foldRight(empty)((h, t) => f(h) append t)
}

val ones: Stream[Int] = Stream.cons(1, ones)

// Ex5_8
def constant[A](a: A): Stream[A] = {
  lazy val tail: Stream[A] = Cons(() => a, () => tail)
  tail
}

// Ex5_9
def from(n: Int): Stream[Int] = {
	cons(n, from(n + 1))
}

// Ex5_10
val fibs = {
	def go(f0: Int, f1: Int): Stream[Int] = {
		cons(f0, go(f1, f0 + f1))
	}
	go(0, 1)
}

// Ex5_11
def unfold[A, S](z: S)(f: S => Option[A, S]): Stream[A] = {
	f(z) match {
		case Some((h,s)) => cons(h, unfold(s)(f))
		case None => empty
	}
}

// Ex5_12
val fibsiaUnfold = {
	unfold((0, 1){case (f0, f1) => Some(f0, (f1, f0+f1))})
}

def fromViaUnfold(n: Int) = {
	unfold(n)(n => Some((n, n+1)))
}

def constantViaUnfold[A](a: A) = {
	unfold(a)(_ => Some((a, a)))
}

def onesViaUnfold = unfold(1)(_ => Some((1, 1)))

// Ex5_15
def tails:Stream[Stream[A]] = {
	unfold(this) {
		case Empty => None
		case s => Some((s, s drop 1))
	} append Stream(empty)
}