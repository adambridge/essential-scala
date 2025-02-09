// Create a generic trait called Maybe of a generic type A with two subtypes,
// Full containing an A, and Empty containing no value. Example usage:

sealed trait Maybe[A]
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val perhaps: Maybe[Int] = Empty[Int]()

val perchance: Maybe[Int] = Full(1)