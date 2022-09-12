package lectures.part3fp

object TuplesAndMaps extends App{
  //tuples = finite ordered lists
 val aTuple = new Tuple2(2, "hello, Scala") //Tuple2[Int, String] = (Int, String)
 // or
 val aTuple1 = (2, "hello,Scala")

  //Tuples can group at most 22 lements of different types. because they are in conjunction with function types and function types are max 22 tyoes

  println(aTuple._1)
  println(aTuple.swap)
  println(aTuple.copy(_2 ="goodbye, Java"))

  //Maps -> key, value
  val aMap: Map[String, Int] = Map()
  val phonebook =Map(("E",123) ,"P" -> 124,"e"->456).withDefaultValue(-1)

  println(phonebook)
  println(phonebook.contains("E"))
  println(phonebook("F")) //default value if key does not exist

  //add a pairing
  val newPairing = "Y" -> 12345
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  //functionals on maps
  println(phonebook.map(x => x._1.toLowerCase -> x._2) )

  //filterKeys
  println(phonebook.filterKeys(x=>x.startsWith("E")) ) //from Scala 2.13 onwards use phonebook.view.filterKeys
  //mapValues
  println(phonebook.mapValues(x => "+91-" + x ))

//conversion to other collection
  println(phonebook.toList)
  println(phonebook.toMap)
  val names= List("Bob", "John", "Jim","Dim", "Damoe")
  println(names.groupBy(x => x.charAt(0)))
 /*
     1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
         !!! careful with mapping keys. keys should be unique
     2.  Overly simplified social network based on maps
         Person = String
         - add a person to the network
         - remove
         - friend (mutual)
         - unfriend
         - number of friends of a person
         - person with most friends
         - how many people have NO friends
         - if there is a social connection between two people (direct or not)
    */



}
