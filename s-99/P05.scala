object P05 {

	def reverseRecursive[A](list: List[A]): List[A] = list match {
		case Nil => Nil
		case h :: tail => reverseRecursive(tail) ::: List(h) 
	}

	// Reverse a list
	def main(args: Array[String]): Unit = {
	  println(reverseRecursive(List(1, 1, 2, 3, 5, 8)))
	}
	
}