class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

Timestamp
new Timestamp(123)

class Person(val firstName: String, val lastName: String) {
  def name = s"$firstName $lastName"
}

object Person {
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    new Person(parts(0), parts(1))
  }
}

Person("Luca Galante").lastName

