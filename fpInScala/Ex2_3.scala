object Ex2_3 {

	def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
		a => b => f(a, b)
	}

	def main(args: Array[String]): Unit = {
	  def sumF = curry((num:Int, num2:Int) => num + num2)
	  def sum = sumF(2)
	  println(sum(3)) // 5
	}
	
}

