// Ex3_16
def add1(l: List[Int]): List[Int] = {
	foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))
}

// Ex3_17
def doubleToString(l: List[Double]): List[String] = {
	foldRight(l, Nil:List[String])((h,t) => Cons(h.toString, t))
}

// Ex3_18
def map[A, B](l: List[A])(f: A => B): List[B] = {
	foldRight(l, Nil]:List[B])((h, t) => Cons(f(h), t))
}

def map_1[A,B](l: List[A])(f: A => B): List[B] = 
  foldRightViaFoldLeft(l, Nil:List[B])((h,t) => Cons(f(h),t))

def map_2[A,B](l: List[A])(f: A => B): List[B] = {
  val buf = new collection.mutable.ListBuffer[B]
  def go(l: List[A]): Unit = l match {
    case Nil => ()
    case Cons(h,t) => buf += f(h); go(t)
  }
  go(l)
  List(buf.toList: _*)
}

// Ex3_19
def filter[A](l: List[A])(f: A => Boolean): List[A] = {
	foldRight(l, Nil:List[A])((h,t) => if (f(h)) Cons(h, t) else t)
}

def filter_1[A](l: List[A])(f: A => Boolean): List[A] = 
  foldRightViaFoldLeft(l, Nil:List[A])((h,t) => if (f(h)) Cons(h,t) else t)

def filter_2[A](l: List[A])(f: A => Boolean): List[A] = {
  val buf = new collection.mutable.ListBuffer[A]
  def go(l: List[A]): Unit = l match {
    case Nil => ()
    case Cons(h,t) => if (f(h)) buf += h; go(t)
  }
  go(l)
  List(buf.toList: _*)
}

// Ex3_20
def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] =
	concat(map(l)(f))

// Ex3_21
def filterViaFlatMap[A](l: List[A])(f: A => Boolean): List[A] =
flatMap(l)(a => if (f(a)) List(a) else Nil)

// Ex3_22
def addList(a: List[Int], b: List[Int]): List[Int] = {
	(a, b) match {
		case (Nil, _) => Nil
		case (_, Nil) => Nil
		case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, addList(t1, t2)) 
	}
}

// Ex3_23
def zipWith[A, B, C](a: List[A], b: List[B])(f: (A, B) => C): List[A] = {
	(a, b) match {
		case (Nil, _) => Nil
		case (_, Nil) => Nil
		case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f)) 
	}
}

// Ex3_24
@annotation.tailrec
def startsWith(l: Lits[A], prefix: List[A]): Boolean = {
	(l, prefix) match {
		case (_, Nil) => Nil
		case (Cons(h1, t1), Cons(h2, t2)) if h1 == h2 => startsWith(t1, t2) 
		case _ => false
	}
}

@annotation.tailrec
def hasSubsequense[A](sup: List[A], sub: List[A]): Boolean = {
	sup match {
		case Nil => sub == Nil
		case _ if startsWith(sup, sub) => true
		case Cons(h, t) => hasSubsequense(t, sub)
	}	
}

// Tree
sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

// Ex3_25
def size[A](t: Tree[A]): Int = {
	t match {
		case Leaf(_) => 1
		case Branch(l, r) => 1 + size(l) + size(r) 
	}
}

// Ex3_26
def maximum(t: Tree[Int]): Int = {
	t match {
		case Leaf(n) => n
		case Branch(l, r) => maximum(l) + maximum(r) 
	}	
}

// Ex3_27
def depth[A](t: Tree[A]): Int = {
	t match {
		case Leaf(_) => 0
		case Branch(l, r) => 1 + (depth(l) max depth(r)) 
	}
}

// Ex3_28
def map[A, B](t: Tree[A])(f: A => B): Tree[B] = {
	t match {
		case Leaf(a) => Leaf(f(a))
		case Branch(l, r) => Branch(map(l)(f), map(r)(f)) 
	}
}

// Ex3_29
def fold[A,B](t: Tree[A])(f: A => B)(g: (B,B) => B): B = t match {
  case Leaf(a) => f(a)
  case Branch(l,r) => g(fold(l)(f)(g), fold(r)(f)(g))
}

def sizeViaFold[A](t: Tree[A]): Int = 
  fold(t)(a => 1)(1 + _ + _)

def maximumViaFold(t: Tree[Int]): Int = 
  fold(t)(a => a)(_ max _)

def depthViaFold[A](t: Tree[A]): Int = 
  fold(t)(a => 0)((d1,d2) => 1 + (d1 max d2))

def mapViaFold[A,B](t: Tree[A])(f: A => B): Tree[B] = 
  fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_,_))

  