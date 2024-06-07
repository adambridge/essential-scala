case class Counter(count: Int = 0) {
  def inc: Counter = copy(count + 1)
  def dec: Counter = copy(count - 1)
  def adjust(adder: Adder): Counter = Counter(adder.add(count))
}