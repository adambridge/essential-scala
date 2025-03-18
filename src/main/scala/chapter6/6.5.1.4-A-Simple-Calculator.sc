import scala.util.matching

/*
A final, longer exercise. Write a method called calculator that accepts three string parameters:

def calculator(operand1: String, operator: String, operand2: String): Unit = ???
and behaves as follows:

Convert the operands to Ints;

Perform the desired mathematical operator on the two operands:

provide support for at least four operations: +, -, * and /;
use Option to guard against errors (invalid inputs or division by zero).
Finally print the result or a generic error message.

Tip: Start by supporting just one operator before extending your method to other cases.
 */

def calculator(operand1: String, operator: String, operand2: String): Unit = {
  def readInt(s: String) = if ("-?\\d+".r matches s) Some(s.toInt) else None

  val result = for {
    o1 <- readInt(operand1)
    o2 <- readInt(operand2)
    answer <- operator match {
      case "+" => Some(o1 + o2)
      case "-" => Some(o1 - o2)
      case "*" => Some(o1 * o2)
      case "/" => if (o2 == 0) None else Some(o1 / o2)
    }
  } yield answer

  result match {
    case Some(x) => println(x)
    case None => println("Error")
  }
}

calculator("2", "+", "3")
calculator("fart", "-", "3")
calculator("13", "/", "3")
calculator("13", "/", "0")

// For the enthusiastic only, write a second version of your code using flatMap and map.

def flalculator(operand1: String, operator: String, operand2: String): Unit = {
  def readInt(s: String) = if ("-?\\d+".r matches s) Some(s.toInt) else None

  val result = readInt(operand1).flatMap { o1 =>
    readInt(operand2).map { o2 =>
      operator match {
        case "+" => Some(o1 + o2)
        case "-" => Some(o1 - o2)
        case "*" => Some(o1 * o2)
        case "/" => if (o2 == 0) None else Some(o1 / o2)
      }
    }
  }

  result match {
    case Some(x) => println(x)
    case None => println("Error")
  }
}

flalculator("2", "+", "3")
flalculator("fart", "-", "3")
flalculator("13", "/", "3")
flalculator("13", "/", "0")

