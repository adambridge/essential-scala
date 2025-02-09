case class Pair[A, B](one: A, two: B)

val pair = Pair[String, Int]("hi", 2)
// pair: Pair[String,Int] = Pair(hi,2)

pair.one
// res0: String = hi

pair.two
// res1: Int = 2