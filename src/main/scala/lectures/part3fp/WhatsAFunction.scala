package lectures.part3fp

object WhatsAFunction extends App {
  //DREAM: use functions as first class elements , like we work with plain values
  // problem: oop, everything is an object or instance of class,

  class Action {
    def execute(element: Int): String = ???
  }

  trait MyFunction[A, B] {
    def apply(element: A):B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(5))

  val stringToIntCoverter= new MyFunction[String,Int] {
    override def apply(element: String): Int = element.toInt
  }

   //function types = Function1[A,B]
   val stringToIntCoverter1= new Function1[String,Int] {
     override def apply(element: String): Int = element.toInt
   }
  println(stringToIntCoverter1( "3" + 4))

  val adder= new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }

  println(stringConcatenator("E","B"))

  //val  tripler = new Function1[Int, Function1[Int,Int]] {

  val superAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int,Int] {
      override def apply (y:Int): Int = x + y
    }
    }

  val adder3 = superAdder(2)
  println(adder3(4))
  println(superAdder(3)(4))

  }




/*

  }

*/
