import scala.annotation.tailrec

sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  def length: Int = fold[Int](0, (h, len) => len + 1)
  def product: Int = fold[Int](1, (h, prod) => prod * h)
  def sum: Int = fold[Int](0, (h, sum) => sum + h)
  def double: IntList = fold[IntList](End, (h, t) => Pair(2 * h, t))
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

val example = Pair(1, Pair(2, Pair(3, End)))
assert(example.length == 3)
assert(example.sum == 6)
assert(example.product == 6)
assert(example.double == Pair(2, Pair(4, Pair(6, End))))