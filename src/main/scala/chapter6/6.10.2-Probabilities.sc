// We now have a model that we can imagine making arbitrarily complex to generate more and more realistic data, but
// we’re missing the element of probability that would allow us to weight the data generation towards more common
// outcomes.
//
// Let’s extend our model to work on List[(A, Double)], where A is the type of data we are generating and the Double is
// a probability. We’re still enumerating all possibilities but we’re now associating a probability with each possible
// outcome.
//
// Start by defining a class Distribution that will wrap a List[(A, Double)]. (Why?)

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

  def myflatMap[B](f: A => Distribution[B]): Distribution[B] =
    Distribution(
      events
        .map((a, p) => (f(a), p))
        .foldRight(List.empty[(B, Double)])((dbp, l) => {
          (dbp match {
            case (Distribution(events), prob) => events.map((b, p) => (b, p * prob))
          }) ++ l
        })
    ).compact.normalize

  def bookflatMap[B](f: A => Distribution[B]): Distribution[B] =
    Distribution(
      events flatMap { case (a, pa) =>
        f(a).events map { case (b, pb) => (b, pa * pb)}
      }
    ).compact.normalize
}

val d1 = Distribution[Int](List((1, 0.2), (2, 0.8)))
val d2 = d1.myflatMap(i => Distribution(List((i * 3, 0.5), (1 * 4, 0.5))))
val d3 = d1.bookflatMap(i => Distribution(List((i * 3, 0.5), (1 * 4, 0.5))))

// We should create some convenience constructors for Distribution. A useful one is uniform which will accept a List[A]
// and create a Distribution[A] where each element has equal probability. Make it so.

object Distribution {
  def uniform[A](events: List[A]): Distribution[A] =
    Distribution(events.map(a => (a, 1 / events.size)))
}