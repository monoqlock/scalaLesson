/**
  * Created by morikawakaori on 2017/01/08.
  */
object Lesson15 {

  def main(args: Array[String]): Unit = {

    val filename = if (args.isEmpty) "config.txt" else args(0)
    println("Filename: " + filename)

    val list = List("Brad Jones", "Steven Gerrard", "Daniel Agger", "Daniel Sturridge")
    for (name <- list if name.startsWith("Daniel")) { println(name)}

    val daniels = for {
      name <- list if name.startsWith("Daniel")
    } yield name
    println(daniels)


    try {
      val input = new java.io.FileInputStream("input.txt")
      input.close()
    } catch {
      case ex: java.io.FileNotFoundException => println("File Not Found")
      case ex: java.io.IOException => println("IOError")
    } finally {
      println("Finally")
    }
  }
}
