object Ch2 {

	def main(args: Array[String]): Unit = {

		var i = 1
		val x = i * 2
		lazy val y = i + 2
		i = 2
	  println("x=" + x + ", y=" + y) // x=2, y=4
	  i = 3
	  println("y=" + y) // y=4 再計算はされない

	  val option: Option[String] = Option("test")
	  println(option) // Some(test)
	  println(option.get) // test
	  println(option.isEmpty) // false
	  println(option.isDefined) // true

	  val option2: Option[String] = Option(null)
	  println(option2) // None
	  println(option2.orNull) // null (値かnullを取得)
	  println(option2.isEmpty) // true
	  println(option2.isDefined) // false
	  println(option2.getOrElse("default")) // default

	  val result: String = {
	  	option match {
	  		case Some(x) => x
	  		case None => ""
	  	}
	  }
	  println(result) // test

	  val map: Map[String, String] = Map("key1" -> "value1", "key2" -> "value2")
	  println(map.get("key1")) // Some(value1)
	  println(map.get("key2").get) // value2
	  println(map.get("key3")) // None


	}
}