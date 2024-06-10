// Following the general rule to implement the method
// inside the class if it has no external dependencies
sealed trait TrafficLight {
  def next: TrafficLight
}
case object Red extends TrafficLight {
  val next: TrafficLight = Green
}
case object Yellow extends TrafficLight {
  val next: TrafficLight = Red
}
case object Green extends TrafficLight {
  val next: TrafficLight = Yellow
}
// OO style makes it easier to add new data (Blue?)

Green.next
Yellow.next
Red.next

sealed trait AltTrafficLight {
  val next: AltTrafficLight =
    this match {
      case AltGreen => AltYellow
      case AltYellow => AltRed
      case AltRed => AltGreen
    }
}
case object AltRed extends AltTrafficLight
case object AltYellow extends AltTrafficLight
case object AltGreen extends AltTrafficLight
// FP style easier to add new method (previous?)

AltGreen.next
AltYellow.next
AltRed.next
