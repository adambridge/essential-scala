def addOptions(x: Option[Int], y: Option[Int]): Option[Int] =
  for {
    xval <- x
    yval <- y
  } yield { xval + yval }

// Overload addOptions with another implementation that accepts three Option[Int] parameters and adds them all together.
def addOptions(x: Option[Int], y: Option[Int], z: Option[Int]): Option[Int] =
  for {
    xval <- x
    yval <- y
    zval <- z
  } yield { xval + yval + zval }

addOptions(Option(11), Option(12), Option(13))
addOptions(Option(11), None, Option(13))

// Write a second version of your code using map and flatMap instead of a for comprehension.
def addOptions2(x: Option[Int], y: Option[Int], z: Option[Int]): Option[Int] =
  x.flatMap { xval =>
    y.flatMap { yval =>
      z.map { zval =>
        xval + yval + zval
      }
    }
  }
