// Write a method addOptions that accepts two parameters of type Option[Int] and adds them together.
// Use a for comprehension to structure your code.

def add(x: Option[Int], y: Option[Int]): Option[Int] =
  for {
    xval <- x
    yval <- y
  } yield { xval + yval }

add(Option(1), Option(2))
add(Option(1), None)

// Write a second version of your code using map and flatMap instead of a for comprehension.

def add2(x: Option[Int], y: Option[Int]): Option[Int] =
  x.flatMap { xval =>
    y.map { yval =>
      xval + yval
    }
  }

add2(Option(1), Option(2))
add2(Option(1), None)
