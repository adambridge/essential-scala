/*
Recall our Sum type.

sealed trait Sum[A, B] {
  def fold[C](left: A => C, right: B => C): C =
    this match {
      case Left(a) => left(a)
      case Right(b) => right(b)
    }
}
final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]

To prevent a name collision between the built-in Either, rename the Left and Right cases to Failure and Success respectively.
*/

sealed trait Sum[A, B] {
  def fold[C](error: A => C, success: B => C): C =
    this match {
      case Failure(e) => error(e)
      case Success(v) => success(v)
    }
  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(e) => Failure(e)
      case Success(v) => Success(f(v))
    }
  def flatMap[C](f: B => Sum[A, C]): Sum[A, C] =
    this match {
      case Failure(e) => Failure(e)
      case Success(v) => f(v)
    }
}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]

val failed: Sum[Int, String] = Failure[Int, String](7)
val succeeded: Sum[Int, String] = Success[Int, String]("Seven")

succeeded.map(_.length * 0.3)

succeeded.flatMap(x => if x.length < 4 then Failure(-1) else Success("OK!"))
