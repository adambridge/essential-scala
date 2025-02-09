import chapter6._

//(More) Heroes of the Silver Screen
//Repeat the following exercises from the previous section without using map or flatMap:

//Nolan Films
//List the names of the films directed by Christopher Nolan.
for {
  film <- nolan.films
} yield film.name

// Cinephile
//List the names of all films by all directors.
for {
  director <- directors
  film <- director.films
} yield film.name

// High Score Table
// Find all films sorted by descending IMDB rating:
val films = for {
  director <- directors
  film <- director.films
} yield film

films.sortWith((f1, f2) => f1.imdbRating > f2.imdbRating)

// Tonight’s Listings
//Print the following for every film: "Tonight only! FILM NAME by DIRECTOR!"
for {
  director <- directors
  film <- director.films
} println(s"Tonight only! ${film.name} by ${director.firstName} Mc${director.lastName}")
