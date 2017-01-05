/**
  * Created by a13180 on 2017/01/04.
  */

object CarExtends {

  def main(args: Array[String]): Unit = {

    println("--")


    var car = new Car("Blue")
    output(car)
    car.run

    var truck = new Truck("Silver")
    output(truck)
    truck.run
  }


  def output(car: Car):Unit = println("Color is %s", car.color + ". ")
}

class Car(val color: String) {
  def run = println("Start!!")
}

class Truck(color: String ) extends Car(color) {
  override def run: Unit = println("Truck Start!!")
}
