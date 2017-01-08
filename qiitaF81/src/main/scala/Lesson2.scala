package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson2 {

	def main(args: Array[String]) {

	  // var calculate = (x: Int) => x + 5 : Int
	  // printf("y=%s \n", calculate(1))
	  // printf("y=%s \n", calculate(2))

	  // val mutable = "Mutable"
	  // printf("%s ", mutable)

	  // mutable = "Change Mutable"
	  // printf("%s ", mutable)

	  // var add = (x: Int) => x + 5
	  // printf("add=%s \n", add(1))
	  // printf("add=%s \n", add(1))
	  // printf("add=%s \n", add(1))

	  val add = (x: Int) => {
	  	val _add = (y: Int) => y + 5
	  	_add(x)
	  }
	  printf("y=%s \n", add(1))
	  printf("y=%s \n", add(2))
	  printf("y=%s \n", add(1))
	}

}
