import munit.FunSuite

class DadTest extends FunSuite {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)

  test("rate") {
    assertEquals(Dad.rate(memento), 3.0)
    assertEquals(Dad.rate(predator), 7.0)
    assertEquals(Dad.rate(outlawJoseyWales), 10.0)
  }
}
