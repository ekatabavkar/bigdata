package lectures.part3fp

object MapFlatMapFilterFor extends App{
val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_+1))
  println(list.map(_+" is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x:Int) => List(x, x+1)
  println(list.flatMap(toPair))

  //concatenation
  val numbers = List (1,2,3,4)
  val chars = List('a','b','c','d')
  val colors =List("black", "white")
  //"iterating"- this is how we avoid for loops
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val combinations1 =numbers.flatMap(n=>chars.flatMap(c=>colors.map(co => "" + c + n +"-" + co)))
  println(combinations1)

  //foreach
  list.foreach(println)

  //in scala - for comprehensions
  val forCombinations = for{
    n <-numbers if n % 2 == 0 //if guard
    c <-chars
    color <- colors
     }yield {"" + c + n +"-" + color}

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
    }

  /*
  1. MyList support for comprehensions? yes if the map, filter and flatMap have the below signatures
  map(f:A => B) => MyList[B]
  filter(f:A:=>Boolean) =Mylist[A]
  flatMap(f:A=>MyList[B]) => MyList[B]

  2. A small collection of at most ONE elemenet - Maybe[+T]
  -map, flatMap, filter
  */

}
