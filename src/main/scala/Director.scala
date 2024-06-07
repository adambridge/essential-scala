case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name: String = s"$firstName $lastName"
 
  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth <= d2.yearOfBirth) d1
    else d2
}