// Write a method addOptions that accepts two parameters of type Option[Int] and adds them together.
// Use a for comprehension to structure your code.

def addOptions(x: Option[Int], y: Option[Int]): Option[Int] =
  for {
    xval <- x
    yval <- y
  } yield { xval + yval }

addOptions(Option(1), Option(2))
addOptions(Option(1), None)

// Write a second version of your code using map and flatMap instead of a for comprehension.

def addOptions2(x: Option[Int], y: Option[Int]): Option[Int] =
  x.flatMap { xval =>
    y.map { yval =>
      xval + yval
    }
  }

addOptions2(Option(1), Option(2))
addOptions2(Option(1), None)
