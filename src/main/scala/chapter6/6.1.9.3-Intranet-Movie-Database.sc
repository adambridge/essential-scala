import chapter6._

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
