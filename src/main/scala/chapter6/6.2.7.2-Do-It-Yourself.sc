
// Minimum
def minInt(s: Seq[Int]): Int =
  s.fold(Int.MaxValue)(
    (minSoFar, nextElem) =>
      if (nextElem < minSoFar) nextElem
      else minSoFar
  )

minInt(-1 to 7)

// Unique
def unique[A](s: Seq[A]): Seq[A] =
  s.foldLeft(Seq.empty[A]) {
    (seqSoFar, nextElem) =>
      if (seqSoFar contains nextElem) seqSoFar
      else seqSoFar :+ nextElem
  }

unique(Vector[Int](7, 7, 8, 9))

// Reverse
def reverse[A](s: Seq[A]): Seq[A] =
  s.foldLeft(Seq.empty[A]) {
    (revSoFar, nextElem) =>
      nextElem +: revSoFar
  }

reverse("esrever").mkString

// Map
def map[A, B](s: Seq[A], fn: A => B): Seq[B] =
  s.foldRight(Seq.empty[B]) {
    (nextElem, mappedSoFar) =>
      fn(nextElem) +: mappedSoFar
  }

map("hello", _.toByte)

// foldLeft
def foldLeft[A, B](s: Seq[A], z: B, fn: (B, A) => B): B = {
  var folded = z
  s.foreach { elem =>
    folded = fn(folded, elem)
  }
  folded
}

foldLeft(Seq(1,2,3), "", (acc, elem) => s"$acc and ${elem.toString}")

