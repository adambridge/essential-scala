// Create a Seq containing the Strings "cat", "dog", and "penguin". Bind it to the name animals.
val animals = Seq("cat", "dog", "penguin")

// Append the element "tyrannosaurus" to animals and prepend the element "mouse".
"mouse" +: animals :+ "tyrannosaurus"

// What happens if you prepend the Int 2 to animals? Why? Try it out… were you correct?
// -> I think it will throw an exception
2 +: animals
// -> oh ok, it does a type conversion
