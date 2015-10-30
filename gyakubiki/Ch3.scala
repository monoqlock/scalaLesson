import scala.util.control.TailCalls._

object Ch3 {

	def multi(times: Int) = (i: Int) => i * times

	def main(args: Array[String]): Unit = {
	 
	 	val multi5 = multi(5)
		println(multi5(4)) // 20
		println(multi(3)(6)) // 18

		def price(total: Int) = "金額: " + total
		// val f: Int => String = price
		def printPrice(f:Int => String) = println(f(1000))
		printPrice(price)

		def greetDef(title: String)(name: String) = title + name
		println(greetDef("Hello!")("Takako")) // Hello!Takako
		def greet(f: String => String) = f("Takako")
		println(greet(greetDef("Hello!"))) // Hello!Takako

		def greeFunc = (title: String, name: String) => title + name
		val curryFunc = greeFunc.curried
		println(curryFunc("Hello!!")("Taro")) // Hello!!Taro

		def plus(total: Int, list: List[Int]): TailRec[Int] = {
			if (list.isEmpty) done(total)
			else tailcall(minus(total + list.head, list.tail))
		}

		def minus(total: Int, list: List[Int]): TailRec[Int] = {
			if (list.isEmpty) done(total)
			else tailcall(plus(total - list.head, list.tail))
		}

		println(plus(0, List(100, 50, 10)).result) // 60

	}
	
	
}