import json.JsonString

/*
Json ::= JsonArray
      | JsonObject
      | JsonString value:String
      | JsonBoolean value:Boolean
      | JsonNumber value:Double
      | JsonNull
JsonArray ::= ArrayCell head:Json tail:JsonArray | ArrayEnd
JsonObject ::= ObjectCell headName:String headValue:Json tail:JsonObject | ObjectEnd
*/

object json {
  sealed trait Json {
    def jsonString: String = {
      def arrayContentStr(array: ArrayCell): String =
        array match {
          case ArrayCell(head, ArrayEnd) => head.jsonString
          case ArrayCell(head, tail @ ArrayCell(_, _)) => s"${head.jsonString}, ${arrayContentStr(tail)}"
        }

      def objectContentStr(obj: ObjectCell): String =
        obj match {
          case ObjectCell(headName, headValue, ObjectEnd) =>
            s"\"$headName\": ${headValue.jsonString}"
          case ObjectCell(headName, headValue, tail @ ObjectCell(_, _, _)) =>
            s"\"$headName\": ${headValue.jsonString}, ${objectContentStr(tail)}"
        }

      this match {
          case JsonNull => "null"
          case JsonBoolean(value) => value.toString
          case JsonNumber(value) => value.toString
          case JsonString(value) => s"\"$value\""
          case ArrayEnd => "[]"
          case arr @ ArrayCell(_, _) => s"[${arrayContentStr(arr)}]"
          case ObjectEnd => "{}"
          case obj @ ObjectCell(_, _, _) => s"{${objectContentStr(obj)}}"
        }
    }
  }
  case object JsonNull extends Json
  final case class JsonBoolean(value: Boolean) extends Json
  final case class JsonNumber(value: Number) extends Json
  final case class JsonString(value: String) extends Json

  sealed trait JsonArray extends Json
  final case class ArrayCell(head: Json, tail:JsonArray) extends JsonArray
  case object ArrayEnd extends JsonArray

  sealed trait JsonObject extends Json
  final case class ObjectCell(headName: String, headValue: Json, tail: JsonObject) extends JsonObject
  case object ObjectEnd extends JsonObject
}

import json.*
val jnull = JsonNull
jnull.jsonString
val jstr = JsonString("hello")
jstr.jsonString
val jnum = JsonNumber(3.0)
jnum.jsonString
val jarr = ArrayCell(JsonString("blah"), ArrayCell(JsonNull, ArrayEnd))
jarr.jsonString
val jobj = ObjectCell("an array", jarr,
  ObjectCell("page", JsonNumber(4), ObjectEnd))
s"${jobj.jsonString}"

ArrayCell(JsonString("a string"), ArrayCell(JsonNumber(1.0), ArrayCell(JsonBoolean(true), ArrayEnd))).jsonString
// res0: String = ["a string", 1.0, true]

ObjectCell(
  "a", ArrayCell(JsonNumber(1.0), ArrayCell(JsonNumber(2.0), ArrayCell(JsonNumber(3.0), ArrayEnd))),
  ObjectCell(
    "b", ArrayCell(JsonString("a"), ArrayCell(JsonString("b"), ArrayCell(JsonString("c"), ArrayEnd))),
    ObjectCell(
      "c", ObjectCell("doh", JsonBoolean(true),
        ObjectCell("ray", JsonBoolean(false),
          ObjectCell("me", JsonNumber(1.0), ObjectEnd))),
      ObjectEnd
    )
  )
).jsonString