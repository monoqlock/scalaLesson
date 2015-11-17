// P02 Find the last but one element of a list.
object P02 {

	def getPenultimateRecursive[A](list: List[A]): A = {
		list match {
			case h :: p :: Nil => h
			case h :: t 			 => getPenultimateRecursive(t)
			case _						 => throw new Exception 
		}
		
	}

	def main(args: Array[String]): Unit = {
	  println(getPenultimateRecursive(List(1, 1, 2, 3, 5, 8)))
	}
	
}