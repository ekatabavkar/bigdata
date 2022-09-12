package lectures.part3fp

object AnonymousFunctions extends App{

  //object oriented way
  val doubler = new Function1[Int, Int]{
    override def apply(v1: Int): Int = v1 * 2 }

  //functional way

  //anonymous function
  val fdoubler = (x:Int)=> x * 2
  //or
  val fdoubler1:Int=>Int  = (x:Int)=> x * 2 //specify types , optional for 1 parameter

  //multiple params in a lambda

  val adder:(Int, Int)=>Int =(x:Int, y:Int) => x + y

//no params

val justDoSomething: () => Int = () => 3


  //curly braces with lambdss // nobdy uses this
  val stringToInt = { ( x : String ) =>
    x.toInt}

  //MORE SYNTACTIC SUGAR

  val niceIncrementer:Int =>Int = _ + 1 // euqivalent
  val niceAdder:(Int,Int)=>Int = _ + _ //for 2 parameters , parameters need to specified  cannot be omitted

  /*
    1.  MyList: replace all FunctionX calls with lambdas
    2.  Rewrite the "special" adder as an anonymous function
   */

  val superAdder= (x:Int)=>(y:Int) => x + y

  println(superAdder(3)(4))



}
