object Ex2_5 extends Any {
	def compose[A,B,C](f: B => C, g: A => B): A => C = {
		a => f(g(a))
	}
}