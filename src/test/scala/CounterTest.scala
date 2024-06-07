import munit.FunSuite

class CounterTest extends FunSuite {
  val counter: Counter = Counter()

  test("defaults to 0") {
    assertEquals(counter.count, 0)
  }

  test("inc/dec") {
    assertEquals(counter.inc.inc.dec.count, 1)
  }

  test("adjust") {
    assertEquals(Counter(100).adjust(Adder(50)).count, 150)
  }
}
