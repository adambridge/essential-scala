val result = Divide(4, 3)
result match {
  case InfiniteResult => "To infinity and beyond!"
  case FiniteResult(value) => s"To $value!"
}