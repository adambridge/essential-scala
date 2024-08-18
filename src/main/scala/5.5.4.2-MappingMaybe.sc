sealed trait Maybe[A] {
  def map[B](f: A => B): Maybe[B] =
    this match {
      case Full(v) => Full(f(v))
      case Empty() => Empty[B]()
    }
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val full: Maybe[Int] = Full(3)
val empty: Maybe[Int] = Empty()
full.map[Double](_ / 4.0)
empty.map[Double](_ / 4.0)
