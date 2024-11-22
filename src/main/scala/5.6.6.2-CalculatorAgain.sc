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