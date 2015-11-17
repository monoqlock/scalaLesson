// P_01 Find the last element of a list.
object P01 {

	def getLastRecursive[A](list: List[A]): A = {
		list match {
			case h :: Nil => h
			case h :: t    => getLastRecursive(t)
			case _ 				 => throw new Exception
		}
		
	}

	def main(args: Array[String]): Unit = {
	  	println(getLastRecursive(List(1, 2, 3, 5)))
	}
}

