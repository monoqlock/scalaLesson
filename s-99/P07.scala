object P07 {

	def flatten(list: List[Any]): List[Any] = list flatMap {
		case ms: List[_] => flatten(ms) 
		case e => List(e)
	}
	
	//  Flatten a nested list structure.
	def main(args: Array[String]): Unit = {
	  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
	}
	
}