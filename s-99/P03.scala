object P03 {
	
	def getNth[A](num: Int, list: List[A]): A = {
		list match {
			case h :: t if list.length >= num  => list(num)
			case _ => throw new Exception
		}
	}

	// Find the Kth element of a list.
	def main(args: Array[String]): Unit = {
	  println(getNth(2, List("zero", "one", "two")))
	}
	
}