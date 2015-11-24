object P04 {
	
	def getLengthRecoursive[A](list: List[A], length: Int = 0): Int = {
		list match {
			case h :: t => getLengthRecoursive(t, length + 1)
			case Nil		=> length
			case _			=> throw new Exception
		}
	}

	// Find the number of elements of a list.
	def main(args: Array[String]): Unit = {
	  println(getLengthRecoursive(List("zero", "one", "two")))
	}
}