/**
  * Created by a13180 on 2017/01/05.
  */
object Literal {

  def main(args: Array[String]): Unit = {
    // 10進数
    val dec = 24
    println("dec : " + dec)

    // 16進数
    val hex = 0x24
    println("hex : " + hex)

    // Long
    val long = 35L
    println("long : " + long)

    // 浮動小数点リテラル
    val big = 1.2
    println("big : " + big)
    val bigger = 1.2e2
    println("bigger : " + bigger)
    val biggerStill = 1.2e45
    println("bigerStill : " + biggerStill)
    val little = 1.2f
    println("little : " + little)

    // 文字列リテラル
    val name = "山田太郎"
    println("name : " + name)
    val sentence =
      """|Test test
        ||test"test
      """.stripMargin
    println("sentense : " + sentence)

    // 真偽値リテラル
    val bool = true
    println("bool : " + bool)

    // シンボルリテラル
    val s = 'synbolA
    println("s : " + s)
  }

}
