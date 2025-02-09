sealed trait Sum[+A, +B] {
  def flatMap[AA >: A, C](f: B => Sum[AA, C]): Sum[AA, C] =
    this match
      case Failure(msg) => Failure(msg)
      case Success(v) => f(v)

  def map[C](f: B => C): Sum[A, C] =
    this match
      case Success(v) => Success(f(v))
      case Failure(msg) => Failure(msg)

  def fold[C](success: B => C, failure: A => C): C =
    this match
      case Success(v) => success(v)
      case Failure(m) => failure(m)
}

final case class Success[B](value: B) extends Sum[Nothing, B]
final case class Failure[A](msg: A) extends Sum[A, Nothing]


sealed trait Expression {
  def eval(): Sum[String, Double] = this match
    case Number(value) => Success(value)

    case SquareRoot(exp) => exp.eval() match
      case Failure(msg) => Failure(msg)
      case Success(v) =>
        if (v > 0) Success(Math.sqrt(v))
        else Failure("Imaginary root")

/*
    // ok
    case Division(l, r) => r.eval() match
      case Failure(msg) => Failure(msg)
      case Success(rval) =>
        if (rval == 0) Failure("Division by 0")
        else l.eval() match
          case Failure(msg) => Failure(msg)
          case Success(lval) => Success(lval / rval)

    // better
    case Division(l, r) => r.eval().flatMap { rval =>
      l.eval().flatMap { lval =>
        if (rval == 0) Failure("Division by 0")
        else Success(lval / rval)
      }
    }
*/

    // best
    case Division(l, r) => summify(l, r, (l, r) =>
      if (r == 0) Failure("Division by 0")
      else Success(l / r)
    )

    case Addition(l, r) => summify(l, r, (l, r) => Success(l + r))
    case Subtraction(l, r) => summify(l, r, (l, r) => Success(l - r))

  def summify(
    l: Expression,
    r: Expression,
    f: (Double, Double) => Sum[String, Double]) =

    l.eval().flatMap { lval =>
      r.eval().flatMap { rval =>
        f(lval, rval)
      }
    }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression

assert(Addition(Number(1), Number(2)).eval() == Success(3))
assert(SquareRoot(Number(-1)).eval() == Failure("Imaginary root"))
assert(Division(Number(4), Number(0)).eval() == Failure("Division by 0"))
assert(Addition(Subtraction(Number(8), Number(6)), Number(2)).eval() == Success(4.0))
assert(Division(Addition(Subtraction(Number(8), Number(6)), Number(2)), Number(2)).eval() == Success(2.0))
