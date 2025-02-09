// Tree with pattern matching
sealed trait Tree {
  def sum: Int =
    this match {
      case Leaf(element) => element
      case Node(left, right) => left.sum + right.sum
    }

  def double: Tree =
    this match {
      case Leaf(element) => Leaf(element * 2)
      case Node(left, right) => Node(left.double, right.double)
    }
}
final case class Leaf(element: Int) extends Tree
final case class Node(left: Tree, right: Tree) extends Tree

val tree = Node(Node(Leaf(1), Leaf(2)), Leaf(3))
assert(tree.sum == 6)
assert(tree.double == Node(Node(Leaf(2), Leaf(4)), Leaf(6)))

// Tree with polymorphism
sealed trait PolyTree {
  def sum: Int
  def double: PolyTree
}
final case class PolyLeaf(element: Int) extends PolyTree {
  def sum: Int = element
  def double: PolyLeaf = PolyLeaf(element * 2)
}
final case class PolyNode(left: PolyTree, right: PolyTree) extends PolyTree {
  def sum: Int = left.sum + right.sum
  def double: PolyNode = PolyNode(left.double, right.double)
}

val polyTree = PolyNode(PolyNode(PolyLeaf(1), PolyLeaf(2)), PolyLeaf(3))
assert(polyTree.sum == 6)
assert(polyTree.double == PolyNode(PolyNode(PolyLeaf(2), PolyLeaf(4)), PolyLeaf(6)))
