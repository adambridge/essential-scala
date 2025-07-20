
final case class Distribution[A](events: List[(A, Double)]) {

  def normalize: Distribution[A] = {
    val totalWeight = (events map { case (a, p) => p }).sum
    Distribution(events map { case (a, p) => a -> (p / totalWeight) })
  }

  def compact: Distribution[A] = {
    val distinct = (events map { case (a, p) => a }).distinct

    def prob(a: A): Double =
      (events filter { case (x, p) => x == a } map { case (a, p) => p }).sum

    Distribution(distinct map { a => a -> prob(a) })
  }

  def map[B](f: A => B): Distribution[B] =
    Distribution[B](events.map((a, p) => (f(a), p)))

  def flatMap[B](f: A => Distribution[B]): Distribution[B] =
    Distribution(
      events flatMap { case (a, pa) =>
        f(a).events map { case (b, pb) => (b, pa * pb)}
      }
    ).compact.normalize
}


object Distribution {
  def uniform[A](events: List[A]): Distribution[A] =
    Distribution(events.map(a => (a, 1 / events.size)))
}

// I put my food into the oven and after some time it ready to eat and produces delicious smell with probability 0.3
// and otherwise it is still raw and produces no smell with probability 0.7. If there are delicious smells the cat comes
// to harass me with probability 0.8, and otherwise it stays asleep. If there is no smell the cat harasses me for the
// hell of it with probability 0.4 and otherwise stays asleep.
//
// Implement this model and answer the question: if the cat comes to harass me what is the probability my food is
// producing delicious smells (and therefore is ready to eat.)

sealed trait Cooking
case object Delicious extends Cooking
case object Odorless extends Cooking

sealed trait Cat
case object Harassment extends Cat
case object Sleep extends Cat

val cooking = Distribution[Cooking](List((Delicious -> 0.3), (Odorless -> 0.7)))
val catSmell = Distribution[Cat](List((Harassment -> 0.8), (Sleep -> 0.2)))
val catNoSmell = Distribution[Cat](List((Harassment -> 0.4), (Sleep -> 0.6)))

for {
  dinner <- cooking
  cat <- if (dinner == Delicious) catSmell else catNoSmell
} yield (dinner, cat)