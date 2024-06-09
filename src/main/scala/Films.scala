case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(candidate: Director): Boolean = director == candidate
}

object Film {
  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating
    else f2.imdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director =
    if (f1.directorsAge >= f2.directorsAge) f1.director
    else f2.director
}

case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int) {
  def name: String = s"$firstName $lastName"
}

object Director {
  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth <= d2.yearOfBirth) d1
    else d2
}

object Dad {
  def rate(film: Film): Double =
    film match {
      case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
      case Film(_, _, _, _) => 3.0
    }
}
