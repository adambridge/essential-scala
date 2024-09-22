//sealed trait Maybe[A]
//final case class Full[A](value: A) extends Maybe[A]
//final case class None[A]() extends Maybe[A]

sealed trait Maybe[A] {

  def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => f(v)
      case Empty() => Empty[B]()
    }

  def map[B](f: A => B): Maybe[B] = {
    def g(v: A): Maybe[B] = {
      this match {
        case Full(v) => Full(f(v))
        case Empty() => Empty[B]()
      }
    }
    flatMap[B](g)
  }
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]