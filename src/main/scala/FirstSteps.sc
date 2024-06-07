println("Welcome to the Scala worksheet")

1 + 1

if (20 > 10) "left" else "right"

println("The ultimate answer is " + 42)

object Oswald {
  val colour: String = "Black"
  val food: String = "Milk"
}

object Henderson {
  val colour: String = "Ginger"
  val food: String = "Chips"
}

object Quentin {
  val colour: String = "Tabby and White"
  val food: String = "Curry"
}

object calc  {
  def square(n: Double): Double = n * n
  def cube(n: Double): Double = n * n * n
}

calc.square(4)
calc.cube(3)

object Uppercaser {
  def uppercase(s: String): String = s.toUpperCase()
}

Uppercaser.uppercase("hello")

object calc2 {
  def square(n: Double): Double = n * n
  def square(n: Int): Int = n * n
  def cube(n: Double): Double = square(n) * n
  def cube(n: Int): Int = square(n) * n
}

//val i: Int = calc.square(4) //Type mismatch

object person {
  val firstName: String = "Jeff"
  val lastName: String = "Jefferson"
}

object alien {
  def greet(p: person.type): String = "Hello, " + p.firstName
}

alien.greet(person)
//alien.greet(alien) //Type mismatch

