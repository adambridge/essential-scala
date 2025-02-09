import chapter6._
// Nolan Films
// Starting with the definition of nolan, create a list containing the names of the films directed by Christopher Nolan.
nolan.films.map(_.name)

// Cinephile
// Starting with the definition of directors, create a list containing the names of all films by all directors.
directors.flatMap(_.films.map(_.name))

// Vintage McTiernan
// Starting with mcTiernan, find the date of the earliest McTiernan film.
// Tip: you can concisely find the minimum of two numbers a and b using math.min(a, b).
mcTiernan.films.map(_.yearOfRelease).foldLeft(Int.MaxValue)(math.min)

// High Score Table
// Starting with directors, find all films sorted by descending IMDB rating:
directors.flatMap(_.films).sortBy(-_.imdbRating)

// Starting with directors again, find the average score across all films:
val ratings = directors.flatMap(_.films).map(_.imdbRating)
ratings.sum / ratings.length

// Tonight’s Listings
// Starting with directors, print the following for every film: "Tonight only! FILM NAME by DIRECTOR!"
directors.foreach { d =>
  d.films.foreach { f =>
    println(s"Tonight only! ${f.name} by ${d.firstName} ${d.lastName}")
  }
}

// From the Archives
// Finally, starting with directors again, find the earliest film by any director:
directors.flatMap { d =>
  d.films.sortBy(_.yearOfRelease).headOption
}
