/*
// My attempt...
sealed trait Maybe[A] {
  def fold[B](end: B)(f: (A, B) => B): B =
    this match {
      case Full(value) => f(value, end)
      case Empty() => end
    }
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val empty = Empty()
val full = Full(1)
empty.fold(0)((a: Int, b: Int) => a + b)
full.fold(0)(_ + _)
 */

sealed trait Maybe[A] {
  def fold[B](empty: B, full: A => B): B = {
    this match {
      case Empty() => empty
      case Full(value) => full(value)
    }
  }
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]