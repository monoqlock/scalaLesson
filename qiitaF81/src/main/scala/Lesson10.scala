package main.scala

/**
  * Created by morikawakaori on 2017/01/07.
  */
object Lesson10 {

  def main(args: Array[String]): Unit = {

    val numSeq = Seq(1, 2, 3)
    val numSeqLong = Seq(1, 2, 3, 4, 5)

    numSeq.foreach(print(_))
    println()

    val seq = numSeq ++ Seq(4,5)
    seq.foreach(print(_))
    println()

    val map = Seq("a", "b", "c") map (_.toUpperCase())
    println(map)

    val flatMap = Seq("red", "blue", "yellow") flatMap(_.toList)
    println(flatMap)

    val collect = numSeq collect{ case (i) if (i % 2 == 1) => i + 1}
    print(collect)
    println()

    val array = numSeq.toArray
    array.foreach(println(_))

    val toiterable = numSeq.toIterable
    println(toiterable)

    val tomap = Seq((1, "Mouse"), (2, "Lucas"), (3, "Henderson")).toMap
    println(tomap)

    val toseq = Map(1 -> "Mouse", 2 -> "Lucas", 3 -> "Hendrson").toSeq
    println(toseq)

    val toset = (numSeq ++ Seq(1)).toSet
    println(toset)

    val tostream = numSeq.toStream
    println(tostream)

    var array2 = Array(4,5,6,7,8)
    Seq(1,2,3).copyToArray(array2)
    array2.foreach(print(_))
    println()

    var buffer = scala.collection.mutable.Buffer(4,5,6,7,8)
    Seq(1,2,3).copyToBuffer(buffer)
    println(buffer)

    println(numSeq.isEmpty)
    println(Seq().isEmpty)

    println(numSeq.nonEmpty)
    println(Seq().nonEmpty)

    println(numSeq.size)

    val find = numSeq.find(_ > 1)
    println(find)

    println(numSeq.head)
    println(numSeq.headOption)
    println(numSeq.last)
    println(numSeq.lastOption)

    println(numSeq.init)

    val take = numSeq.take(2)
    println(take)

    println(numSeq.drop(2))

    val filter = numSeq.filter(_ % 2 == 1)
    println(filter)

    val filternot = numSeq.filterNot(_ % 2 == 1)
    println(filternot)

    val slice = numSeqLong.slice(2, 5)
    println(slice)

    println(numSeq.tail)
    println(numSeq.count(_ % 2 == 1))

    println(numSeq.exists(_ > 3))
    println(numSeq.exists(_ > 2))

    val groupby = numSeqLong.groupBy(_ % 2 == 1)
    println(groupby)

    val partition = numSeqLong.partition(_ % 2 == 1)
    println(partition)

    val span = numSeqLong.span(_ < 3)
    println(span)

    println(numSeq.splitAt(1))

    val foldleft = numSeq.foldLeft(10)(_ - _)
    println(foldleft) // 4
    val foldright = numSeq.foldRight(10)(_ - _)
    println(foldright) // -8
    val reduceleft = numSeq.reduceLeft(_ - _)
    println(reduceleft) // -4
    val reduceright = numSeq.reduceRight(_ - _)
    println(reduceright) // 2

    println(numSeq.sum)
    println(numSeq.max)
    println(numSeq.min)

    var stringbuiler = new StringBuilder
    println(numSeq.addString(stringbuiler))

    println(numSeq.mkString(","))

    println(numSeq.view)
  }

}
