import munit.FunSuite

class DirectorTest extends FunSuite {
  val alfred: Director = Director("Alfred", "Hitchcock", 1899)
  val john: Director = Director("John", "Carpenter", 1948)

  test("name") {
    assertEquals(alfred.name, "Alfred Hitchcock")
  }

  test("older") {
    assertEquals(alfred, Director.older(alfred, john))
    assertEquals(alfred, Director.older(john, alfred))
  }
}
