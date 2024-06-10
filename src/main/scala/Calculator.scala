
sealed trait Calculation
case class Success(result: Int) extends Calculation
case class Failure(message: String) extends Calculation

object Calculator {
  def +(previous: Calculation, addend: Int): Calculation = {
    previous match {
      case Success(result) => Success(result + addend)
      case Failure(message) => Failure(message)
    }
  }
  def -(previous: Calculation, subtrahend: Int): Calculation = {
    previous match {
      case Success(result) => Success(result - subtrahend)
      case Failure(message) => Failure(message)
    }
  }
  def /(previous: Calculation, divisor: Int): Calculation = {
    if (divisor == 0) Failure("Division by zero")
    else previous match {
      case Success(result) => Success(result / divisor)
      case Failure(message) => Failure(message)
    }
  }
}




