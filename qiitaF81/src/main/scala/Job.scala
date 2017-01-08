package main.scala

/**
  * Created by morikawakaori on 2017/01/08.
  */
trait Job {
  val name: String
  def getName() = {
    "My job is " + name
  }
}
