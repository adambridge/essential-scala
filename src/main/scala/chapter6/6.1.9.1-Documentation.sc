/*
Discovering Scala’s collection classes is all about knowing how to read the API documentation.
Look up the Seq and List types now and answer the following:

There is a synonym of length defined on Seq—what is it called?
-> size
*/
val l = Seq(1,2,3)
l.size

/*
There are two methods for retrieving the first item in a List – what are they called and how do they differ?
-> head and headOption
head returns the first element or throws if there isn't one
headOption always returns an Option, either Some(element) or None
*/
List(1,2,3).head
List(1,2,3).headOption
List.empty.head
List.empty.headOption
/*

What method can be used to display the elements of the sequence as a string?
-> mkSting
*/
List(1,2,3).mkString

/*
What method of Option can be used to determine whether the option contains a value?
-> isEmtpy / is Defined
*/
Some(1).isEmpty
Some(1).isDefined
None.isEmpty
None.isDefined
