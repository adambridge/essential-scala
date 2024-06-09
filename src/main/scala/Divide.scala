object Divide {
  def apply(a: Int, b: Int): DivisionResult =
    if (b == 0) InfiniteResult
    else FiniteResult(a / b)
}

sealed trait DivisionResult

final case class FiniteResult(value: Int) extends DivisionResult

case object InfiniteResult extends DivisionResult
