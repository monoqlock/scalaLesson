package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson1 { // object -シングルトンオブジェクトの定義

  def main(args: Array[String]) {

  	if (args.size == 0) {
  		val strs = Array("Hello", "World")
  		output(strs)

  	} else {
  		printf("Invalid Args")
  	}
  }

  def output(strs: Array[String]){
  	strs.foreach(printf("%s ", _))
  }
}
