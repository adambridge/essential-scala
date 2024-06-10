import munit.FunSuite

class CalculatorTest extends FunSuite {
  test("-/+") {
    assertEquals(Calculator.+(Success(11), 7), Success(18))
    assertEquals(Calculator.-(Success(11), 7), Success(4))
    assertEquals(Calculator.+(Failure("Nope"), 7), Failure("Nope"))
    assertEquals(Calculator.-(Failure("Nuh-uh"), 7), Failure("Nuh-uh"))
  }
  test("divide"){
    assertEquals(Calculator./(Success(14), 7), Success(2))
    assertEquals(Calculator./(Failure("Nope"), 7), Failure("Nope"))
    assertEquals(Calculator./(Success(14), 0), Failure("Division by zero"))
  }
}
