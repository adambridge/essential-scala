sealed trait Sum[A, B] {
  def fold[C](l: A => C, r: B => C): C =
    this match {
      case Left(value) => l(value)
      case Right(value) => r(value)
    }
}
final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]

val s1: Sum[Int, String] = Left(1)
val s2: Sum[Int, String] = Right("1")

s1.fold[String](_.toString, s => s)
s2.fold[String](_.toString, s => s)
s1.fold[Int](i => i, _.toInt)
s2.fold[Int](i => i, _.toInt)
