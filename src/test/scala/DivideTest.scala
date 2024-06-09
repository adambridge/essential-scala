import munit.FunSuite

class DivideTest extends FunSuite {
  test("divide") {
    assertEquals(Divide(1, 0), InfiniteResult)
    assertEquals(Divide(6, 2), FiniteResult(3))
  }
}
