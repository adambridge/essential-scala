/*
Using the notation A <: B to indicate A is a subtype of B and assuming:

  Siamese <: Cat <: Animal; and
  Purr <: CatSound <: Sound

if I have a method

def groom(groomer: Cat => CatSound): CatSound = {
  val oswald = Cat("Black", "Cat food")
  groomer(oswald)
}

which of the following can I pass to groom?

A function of type Animal => Purr
A function of type Siamese => Purr
A function of type Animal => Sound

groom can accept subtypes of Cat => CatSound
functions are contravariant in terms of their arguments
and covariant in terms of their return type
so Animal => Purr is a subtype but
Siamese => Purr and Animal => Sound are not

 */