// We’ll start by generating text. Imagine we wanted to generate (somewhat) realistic text, perhaps to use as a
// placeholder to fill in parts of a website design. If we took a large amount of real text we could analyse to work out
// for each word what the most common words following it are. Such a model is known as a Markov chain.
//
// To keep this example to a reasonable size we’re going to deal with a really simplified version of the problem, where
// all sentences have the form subject-verb-object. For example, “Noel wrote code”.
//
// Write a program to generate all possible sentences given the following model:

val subjects = List("Noel", "The cat", "The dog")
val verbs = List("wrote", "chased", "slept on")
val objects = List("the book", "the ball", "the bed")

for {
  subject <- subjects
  verb <- verbs
  objekt <- objects
} yield s"$subject $verb $objekt"

// This model creates some clearly nonsensical sentences. We can do better by making the choice of verb dependend on the
// subject, and the object depend on the verb.
//
//  Let’s use the following model:
//
//  The subjects are as before.
//    For the verbs:
//    If the subject is “Noel” the possible verbs are “wrote”, “chased”, and “slept on”.
// If the subject is “The cat” the possible verbs are “meowed at”, “chased”, and “slept on”.
// If the subject is “The dog” the possible verbs are “barked at”, “chased”, and “slept on”.
// For the objects:
// If the verb is “wrote” the possible objects are “the book”, “the letter”, and “the code”.
// If the verb is “chased” the possible objects are “the ball”, “the dog”, and “the cat”.
// If the verb is “slept on” the possible objects are “the bed”, “the mat”, and “the train”.
// If the verb is “meowed at” the possible objects are “Noel”, “the door”, “the food cupboard”.
// If the verb is “barked at” the possible objects are “the postman”, “the car”, and “the cat”.
//
// Implement this.

val verbsForSubject: Map[String, List[String]] = Map(
  "Noel" -> List("wrote", "chased", "slept on"),
  "The cat" -> List("meowed at", "chased", "slept on"),
  "The dog" -> List("barked at", "chased", "slept on")
)

val objectsForVerb: Map[String, List[String]] = Map(
  "wrote" -> List("the book", "the letter", "the code"),
  "chased" -> List("the ball", "the dog", "the cat"),
  "slept on" -> List("the bed", "the mat", "the train"),
  "meowed at" -> List("Noel", "the door", "the food cupboard"),
  "barked at" -> List("the postman", "the car", "the cat")
)

for {
  subject <- subjects
  verb <- verbsForSubject(subject)
  objekt <- objectsForVerb(verb)
} yield s"$subject $verb $objekt"
