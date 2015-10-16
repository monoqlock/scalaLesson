object Ex2_2 {

	def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
		@annotation.tailrec
		def loop(count: Int) : Boolean = {
			// println("count=" + count + ", length=" + as.length + ", as(count)=" + as(count))
			if ((count + 1) >= as.length) true
			else if (!ordered(as(count), as(count + 1))) false
			else loop(count + 1)
		}

		loop(0)
	}


	def main(args: Array[String]): Unit = {
		val arr = Array(5, 1, 0)
		def gt(num1: Int, num2: Int): Boolean = {
			num1 > num2
		}

	  println(isSorted(arr, gt))
	}
	
}