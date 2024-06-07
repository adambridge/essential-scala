case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(candidate: Director): Boolean = director == candidate

  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating
    else f2.imdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director =
    if (f1.directorsAge >= f2.directorsAge) f1.director
    else f2.director
}
