package lectures.part1basics

object StringOps extends App{
  val str="Hello, I am learning scala"
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.startsWith("Hello"))
  println(str.split(" ").toList)
  println(str.replace(" ","-"))
  println(str.toLowerCase)
  println(str.reverse)
  println(str.contains("Hello"))
  println(str.take(2))

  val aNumberString="45"
  val aNumber=aNumberString.toInt
  println('a'+aNumberString+"z")

  //Scala specific interpolcators
  val speed=1.2f
  val name="David"
  val greeting=f"$name%s can eat $speed%2.2f burgers in a  day and ${1+1} sandwiches at night. Burger cost is $$14.99 To print double quotes. enter triple quotes  " //%s for string , %d for integer %f for double representation
  println(greeting)
  println(raw"This is a \n newline")
  val escaped="This is a \n newline"
  println(raw"$escaped") // this does not get escaped
}

