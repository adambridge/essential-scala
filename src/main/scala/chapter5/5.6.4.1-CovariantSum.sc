sealed trait Sum[+A, +B] {
  def flatMap[AA >: A, C](f: B => Sum[AA, C]): Unit =
    this match {
      case Failure(e) => Failure(e)
      case Success(v) => f(v)
  }
}
final case class Failure[A](value: A) extends Sum[A, Nothing]
final case class Success[B](value: B) extends Sum[Nothing, B]
