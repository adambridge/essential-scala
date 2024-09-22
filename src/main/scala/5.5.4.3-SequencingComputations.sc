// Given:
val list = List(1, 2, 3)
// Make a list with evey element and its negation

val withNegs = list.flatMap(e => List(e, -e))


// Given this list
val maybes: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))
// return a List[Maybe[Int]] containing None for the odd elements. Hint: If x % 2 == 0 then x is even.

def noOddsPlease(i: Int): Maybe[Int] =
  if i % 2 == 0 then Full(i)
  else Empty[Int]()

val fullOne = Full(1)
val fullTwo = Full(2)
fullOne.flatMap(i => noOddsPlease(i))
fullTwo.flatMap(i => noOddsPlease(i))

maybes.map(m => m.flatMap(i => noOddsPlease(i)))

maybes.map(m =>
  m.flatMap(i =>
    if i % 2 == 0 then Full(i)
    else Empty[Int]()
  )
)

