import scala.sys.process.ProcessBuilder.Source

sealed trait TrafficLight
case object Red extends TrafficLight
case object Yellow extends TrafficLight
case object Green extends TrafficLight

sealed trait Result
case class Success(result: Int) extends Result
case class Failure(message: String) extends Result

case class Water(size: Int, source: Source, carbonated: Boolean)
sealed trait Source
case object Well extends Source
case object Tap extends Source
case object Spring extends Source
