// 6.8.4 Do-It-Yourself Part 2
// Now we have some practice with maps and sets let’s see if we can implement some useful library functions for ourselves.
//
// 6.8.4.1 Union of Sets
// Write a method that takes two sets and returns a set containing the union of the elements.
// Use iteration, like map or foldLeft, not the built-in union method to do so!

def union[T](a: Set[T], b: Set[T]): Set[T] = b.foldLeft(a) {
  (union, elem) => union + elem
}

union(Set(1, 2), Set(3, 4))

// 6.8.4.2 Union of Maps
// Now let’s write union for maps. Assume we have two Map[A, Int] and add corresponding elements in the two maps.
// So the union of Map('a' -> 1, 'b' -> 2) and Map('a' -> 2, 'b' -> 4) should be Map('a' -> 3, 'b' -> 6).

def union[K](a: Map[K, Int], b: Map[K, Int]): Map[K, Int] = b.foldLeft(a) {
  (union, elem) =>
    union + (elem._1 -> (union.getOrElse(elem._1, 0) + elem._2))
}

union(Map('a' -> 1, 'b' -> 2), Map('a' -> 2, 'b' -> 4))

// 6.8.4.3 Generic Union
//
// There are many things that can be added, such as strings (string concatenation), sets (union), and of course numbers.
// It would be nice if we could generalise our union method on maps to handle anything for which a sensible add operation can be defined.
// How can we go about doing this?

def union[K, V](
                 a: Map[K, V],
                 b: Map[K, V],
                 add: (V, V) => V,
                 zero: V
               ): Map[K, V] = b.foldLeft(a) {
  (union, elem) =>
    union + (elem._1 -> add(union.getOrElse(elem._1, zero), elem._2))
}

union[String, String](Map("a" -> "b", "b" -> "c"), Map("a" -> "c"), _ + _, "")

// Can do without passing a zero:
def union[K, V](
                 a: Map[K, V],
                 b: Map[K, V],
                 add: (V, V) => V
               ): Map[K, V] = b.foldLeft(a) {
  (union, elem) => {
    val (k, v) = elem
    val newV = union.get(k).map(o => add(o, v)).getOrElse(v)
    union + (elem._1 -> newV)
  }
}

union[String, String](Map("a" -> "b", "b" -> "c"), Map("a" -> "c"), _ + _)
