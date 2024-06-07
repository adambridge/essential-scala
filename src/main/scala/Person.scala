case class Person(firstName: String, lastName: String) {
  def name = s"$firstName $lastName"
}

object Person {
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    new Person(parts(0), parts(1))
  }
}