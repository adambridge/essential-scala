// An Expression is an Addition, Subtraction, or a Number;
// An Addition has a left and right Expression;
// A Subtraction has a left and right Expression; or
// A Number has a value of type Double.

sealed trait Calculation
final case class Success(result: Double) extends Calculation
final case class Failure(reason: String) extends Calculation

sealed trait Expression {
  def eval: Calculation = {
    this match {
      case Number(value) => Success(value)
      case Addition(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(lResult) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(rResult) => Success(lResult + rResult)
            }
        }
      case Subtraction(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(lResult) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(rResult) => Success(lResult - rResult)
            }
        }
      case Division(l, Number(0)) => Failure("Division by zero.")
      case Division(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(lResult) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(rResult) => Success(lResult / rResult)
            }
        }
      case SquareRoot(expression) =>
        expression.eval match {
          case Failure(reason) => Failure(reason)
          case Success(result) =>
            if (result < 0) Failure("Imaginary root.")
            else Success(Math.sqrt(result))
        }
    }
  }
}
final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(expression: Expression) extends Expression


val onePlusTwo = Addition(Number(1), Number(2))
assert(onePlusTwo.eval == Success(3))

val sixOverTwo = Division(Number(6), Number(2))
assert(sixOverTwo.eval == Success(3))

val oneOverZero = Division(Number(1), Number(0))
assert(oneOverZero.eval == Failure("Division by zero."))

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval ==
  Failure("Imaginary root."))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
assert(Division(Number(4), Number(0)).eval == Failure("Division by zero."))