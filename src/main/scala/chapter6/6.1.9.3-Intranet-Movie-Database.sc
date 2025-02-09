case class Film(
                 name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)

case class Director(
                     firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])

val memento           = Film("Memento", 2000, 8.5)
val darkKnight        = Film("Dark Knight", 2008, 9.0)
val inception         = Film("Inception", 2010, 8.8)

val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales  = Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven        = Film("Unforgiven", 1992, 8.3)
val granTorino        = Film("Gran Torino", 2008, 8.2)
val invictus          = Film("Invictus", 2009, 7.4)

val predator          = Film("Predator", 1987, 7.9)
val dieHard           = Film("Die Hard", 1988, 8.3)
val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6)
val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8)

val eastwood = Director("Clint", "Eastwood", 1930,
  Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))

val mcTiernan = Director("John", "McTiernan", 1951,
  Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))

val nolan = Director("Christopher", "Nolan", 1970,
  Seq(memento, darkKnight, inception))

val someGuy = Director("Just", "Some Guy", 1990,
  Seq())

val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

// Using this sample code, write implementations of the following methods:
//
// 1. Accept a parameter numberOfFilms of type Int—find all directors who have directed more than numberOfFilms:
def directedMoreThan(numberOfFilms: Int): Seq[Director] =
  directors.filter(_.films.length > numberOfFilms)

// 2. Accept a parameter year of type Int—find a director who was born before that year
def bornBefore(year: Int): Option[Director] =
  directors.find(_.yearOfBirth < year)

// 3. Accept two parameters, year and numberOfFilms, and return a list of directors who were born before year who have
//    also directed more than that numberOfFilms:
def bornBeforeAndDirectedMoreThan(year: Int, films: Int): Seq[Director] =
  directedMoreThan(films).filter(_.yearOfBirth < year)

// 4. Accept a parameter ascending of type Boolean that defaults to true. Sort the directors by age in the specified order:
def bornBeforeAndDirectedMoreThanByAge(year: Int, films: Int, asc: Boolean = true): Seq[Director] = {
  val results = directedMoreThan(films).filter(_.yearOfBirth < year)
  if (asc) {
    results.sortBy(- _.yearOfBirth)
  } else {
    results.sortBy(_.yearOfBirth)
  }
}

directedMoreThan(3).map(_.lastName)
bornBefore(2005).map(_.lastName)
bornBeforeAndDirectedMoreThan(1960, 4).map(_.lastName)
bornBeforeAndDirectedMoreThan(1960, 4).map(_.lastName)
bornBeforeAndDirectedMoreThanByAge(1998, 2, false).map(_.lastName)
