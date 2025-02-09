sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait LinkedList[A] {
  def length: Int =
    this match {
      case End() => 0
      case Pair(head, tail) => 1 + tail.length
    }
  def contains(elem: A): Boolean =
    this match {
      case End() => false
      case Pair(head, tail) =>
        if (head == elem) true
        else tail.contains(elem)
    }
  def apply(index: Int): Result[A] =
    this match {
      case End() => Failure("Index exceeds list length.")
      case Pair(head, tail) =>
        if (index == 0) Success(head)
        else tail(index - 1)
    }
}
final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)

assert(example.contains(3))
assert(!example.contains(4))
assert(!End().contains(0))
// This should not compile
// example.contains("not an Int")

//assert(example(0) == 1)
//assert(example(1) == 2)
//assert(example(2) == 3)
//assert(try {
//  example(3)
//  false
//} catch {
//  case e: Exception => true
//})

assert(example(0) == Success(1))
assert(example(1) == Success(2))
assert(example(2) == Success(3))
assert(example(3) == Failure("Index out of bounds"))