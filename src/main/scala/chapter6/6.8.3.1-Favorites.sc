val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")

val ages = Map(
  "Alice"   -> 20,
  "Bob"     -> 30,
  "Charlie" -> 50,
  "Derek"   -> 40,
  "Edith"   -> 10,
  "Fred"    -> 60)

val favoriteColors = Map(
  "Bob"     -> "green",
  "Derek"   -> "magenta",
  "Fred"    -> "yellow")

val favoriteLolcats = Map(
  "Alice"   -> "Long Cat",
  "Charlie" -> "Ceiling Cat",
  "Edith"   -> "Cloud Cat")

// ÅUse the code as test data for the following exercises:

// Write a method favoriteColor that accepts a person’s name as a parameter and returns their favorite colour.
def favoriteColor(name: String): Option[String] = favoriteColors.get(name)

favoriteColor("Derek")
favoriteColor("Simon Quinlag")

// Update favoriteColor to return a person’s favorite color or beige as a default.
def favoriteColor2(name: String): String =
  favoriteColors.get(name).getOrElse("beige")

favoriteColor("Derek")
favoriteColor("Simon Quinlag")
favoriteColor2("Derek")
favoriteColor2("Simon Quinlag")

// Write a method printColors that prints everyone’s favorite color!
def printColors: Unit =
  for {
    (name, color) <- favoriteColors
  } yield {
    println(s"$name's favorite color is $color")
  }

printColors

// Write a method lookup that accepts a name and one of the maps and returns the relevant value from the map.
// Ensure that the return type of the method matches the value type of the map.
def lookup[T](name: String, map: Map[String, T]): Option[T] =
  map.get(name)

lookup("Derek", favoriteColors)
lookup("Simon Quinlag", favoriteLolcats)

// Calculate the color of the oldest person:
val oldest: String = ages.maxBy((name, age) => age)._1
val fave = favoriteColor(oldest)

// Safer?
val oldest2: Option[String] =
  people.foldLeft(Option.empty[String]) {
    (oldestSoFar, person) => {
      val maxAgeSoFar: Int = oldestSoFar.flatMap(ages.get).getOrElse(0)
      val personsAge: Int = ages.getOrElse(person, 0)
      if (personsAge > maxAgeSoFar) {
        Some(person)
      } else {
        oldestSoFar
      }
    }
  }
