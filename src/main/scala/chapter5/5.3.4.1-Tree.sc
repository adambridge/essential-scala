// A Tree of type A is a Node with a left and right Tree or a Leaf with an element of type A.
// Implement this algebraic data type along with a fold method.

sealed trait Tree[A] {
  def myFold[B](end: B)(f: (A, B) => B): B =
    this match {
      case Leaf(elem) => f(elem, end)
      case Node(l, r) => l.myFold(r.myFold(end)(f))(f)
    }
  def bookFold[B](foldLeaf: A => B, foldNode: (B, B) => B): B
}
final case class Node[A](l: Tree[A], r: Tree[A]) extends Tree[A] {
  def bookFold[B](foldLeaf: A => B, foldNode: (B, B) => B): B =
    foldNode(l.bookFold(foldLeaf, foldNode), r.bookFold(foldLeaf, foldNode))
}
final case class Leaf[A](elem: A) extends Tree[A] {
  def bookFold[B](foldLeaf: A => B, foldNode: (B, B) => B): B =
    foldLeaf(elem)
}

val t = Node(Node(Leaf(1), Leaf(2)), Leaf(3))
val sum = (x: Int, y:Int) => x + y
t.myFold(0)(sum)
// or use placeholder syntax:
t.myFold(0)(_ + _)

val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

tree.myFold("")(_ + " " + _)
tree.bookFold[String](s => s, _ + " " + _)