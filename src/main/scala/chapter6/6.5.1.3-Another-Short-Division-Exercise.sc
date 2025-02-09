// Write a method divide that accepts two Int parameters and divides one by the other.
// Use Option to avoid exceptions when the denominator is 0.
def divide(x: Int, y: Int): Option[Int] =
  if (y == 0) None
  else Option(x/y)

divide(1, 0)
divide(10, 2)

// Using your divide method and a for comprehension,
// write a method called divideOptions that accepts two parameters of type Option[Int] and divides one by the other:
def divideOptions(xOpt: Option[Int], yOpt: Option[Int]): Option[Int] = {
  for {
    x <- xOpt
    y <- yOpt
    z <- divide(x, y)
  } yield z
}

divideOptions(Option(10), Option(2))
divideOptions(Option(10), None)
divideOptions(Option(10), Option(0))
