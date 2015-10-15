object MyModule {
  
  def getFibonacciNum(count:Int): Int = {

    def loop(count:Int, num1: Int, num2: Int): Int = {
      // println("num1: " + num1 + ", num2: " +num2)
      if (count <= 3) num1 + num2
      else loop(count - 1, num2, num1 + num2)
    }

    if (count == 0) 0
    else if (count == 1) 1
    else loop(count, 0, 1)
  }

  def main(args: Array[String]) : Unit = {
    println(getFibonacciNum(6))
  }
}


