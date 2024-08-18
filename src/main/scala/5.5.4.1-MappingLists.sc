sealed trait LinkedList[A] {
  def map[B](f: A => B): LinkedList[B] =
    this match {
      case Pair(h, t) => Pair(f(h), t.map(f))
      case End() => End()
    }
}
final case class Pair[A](h: A, t: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

//double all the elements in the list;
list.map(2 * _)
//add one to all the elements in the list; and
list.map(_ + 1)
//divide by three all the elements in the list.
list.map(_ / 3)
