sealed trait Maybe[A] {
  def map[B](f: A => B): Maybe[B] =
    this match {
      case Full(v) => Full(f(v))
      case Empty() => Empty[B]()
    }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => f(v)
      case Empty() => Empty[B]()
    }

  def map2[B](f: A => B): Maybe[B] = {
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

val full: Maybe[Int] = Full(3)
val empty: Maybe[Int] = Empty()
full.map[Double](_ / 4.0)
empty.map[Double](_ / 4.0)
full.map2[Double](_ / 4.0)
empty.map2[Double](_ / 4.0)
