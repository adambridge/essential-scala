import munit.FunSuite

class PersonTest extends FunSuite {
  val jeff: Person = Person("Jeff Jefferson")

  test("firstname, lastname, name") {
    assertEquals(jeff.name, "Jeff Jefferson")
    assertEquals(jeff.firstName, "Jeff")
    assertEquals(jeff.lastName, "Jefferson")
  }
}
