object P06 {
	
	def isPalindromeRecursive[A](list: List[A], index: Int = 0): Boolean = list match {
		case Nil => false
		case h :: t if (index == list.length / 2) => true
		case h :: t if (list(index) == list(list.length - index - 1)) => isPalindromeRecursive(list, index + 1)
		case _ => false  
	}

	// Find out whether a list is a palindrome.
	def main(args: Array[String]): Unit = {
	  println(isPalindromeRecursive(List(1, 2, 3, 2, 1))) // true
	  println(isPalindromeRecursive(List(2, 3, 4))) // false
	}
}