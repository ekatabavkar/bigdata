package lectures.part4pm

object PatternsEverywhere extends App{

  try {
    //code
  }
  catch{
    case  e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"

    }

  //catches are actually MATCHES

 /*
  try {
    //code
    val e= RuntimeException
  }
  catch (e){
  e match  {
    case RuntimeException => "runtime"
    case NullPointerException => "npe"
    case _ => "something else"
   }
  }
*/
 //big idea #1

  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 ==0 // ?!
  } yield 10 * x
   //generators are also pattern matching

  val tuples = List((1,2),(3,4))
  val filterTuples = for {
    (first,second) <- tuples
  } yield first * second


  //boig idea # 3
  val tuple = (1,2,3)
  val (a, b, c) = tuple //using name binding property
  println(b)

   val head :: tail = list
  println(head)
  println(tail)

  // big idea # 4 - NEw
  //partial function
  val mappedList = list.map {
    case 1 => "the one"
    case n if n % 2 == 0 =>  s"$n - Even"
    case _ => "something else"
  }
  println(mappedList)
}
