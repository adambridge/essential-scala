import munit.FunSuite

class FilmTest extends FunSuite {
  val alfred: Director = Director("Alfred", "Hitchcock", 1899)
  val birds: Film = Film("The Birds", 1963, 7.6, alfred)
  val john: Director = Director("John", "Carpenter", 1948)
  val escapeFromNY: Film = Film("Escape from New York", 1981, 7.1, john)

  test("directorsAge") {
    assertEquals(birds.directorsAge, 64)
  }

  test("isDirectedBy") {
    assertEquals(escapeFromNY.isDirectedBy(alfred), false)
  }

  test("highestRating") {
    assertEquals(Film.highestRating(birds, escapeFromNY), 7.6)
  }

  test("oldestDirectorAtTheTime") {
    assertEquals(Film.oldestDirectorAtTheTime(birds, escapeFromNY), alfred)
  }
}
