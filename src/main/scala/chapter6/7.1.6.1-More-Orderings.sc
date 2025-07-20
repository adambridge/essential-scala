import scala.math.abs
// Define an Ordering that orders Ints from lowest to highest by absolute value. The following test cases should pass.

implicit val absOrdering: Ordering[Int] = Ordering.fromLessThan[Int](abs(_) < abs(_))

assert(List(-4, -1, 0, 2, 3).sorted(absOrdering) == List(0, -1, 2, 3, -4))
assert(List(-4, -3, -2, -1).sorted(absOrdering) == List(-1, -2, -3, -4))

