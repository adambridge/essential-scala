// Scala doesn’t have a class to represent rational numbers, but we can easily implement one ourselves.

final case class Rational(numerator: Int, denominator: Int)

// Implement an Ordering for Rational to order rationals from smallest to largest. The following test case should pass.
implicit val rationalOrdering: Ordering[Rational] =
  Ordering.fromLessThan((rat1, rat2) =>
    rat1.numerator.toDouble / rat1.denominator.toDouble
    < rat2.numerator.toDouble / rat2.denominator.toDouble
  )

assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
  List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))