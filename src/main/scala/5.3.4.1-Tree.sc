// A Tree of type A is a Node with a left and right Tree or a Leaf with an element of type A.
// Implement this algebraic data type along with a fold method.

sealed trait Tree[A] {
  def fold[B](end: B)(f: (A, B) => B): B =
    this match {
      case Leaf(elem) => f(elem, end)
      case Node(l, r) => r.fold(l.fold(end)(f))(f)
    }
}
final case class Node[A](l: Tree[A], r: Tree[A]) extends Tree[A]
final case class Leaf[A](elem: A) extends Tree[A]

val t = Node(Node(Leaf(1), Leaf(2)), Leaf(3))
val sum = (x: Int, y:Int) => x + y
t.fold(0)(sum)
// or use placeholder syntax:
t.fold(0)(_ + _)