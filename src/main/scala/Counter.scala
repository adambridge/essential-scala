class Counter(val count: Int = 0) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
  def adjust(adder: Adder) = new Counter(adder.add(count))
}