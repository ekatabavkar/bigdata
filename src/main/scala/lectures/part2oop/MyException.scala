package lectures.part2oop


object MyException extends App{
  //val x:String = null
  //println(x.length) This will cr4ash with Null Pointer Exception

  //throwing and catching exceptions
  //val aWierdValue :String = throw new NullPointerException // this expression returns Nothing, this dos not hold value. Nothing
  //Exceptions are instances of classes new keyword is used instantiate NullPointer Exception Class

  //throwable classes extend the Throwable class
  //Exception and Error are the major throwable subtypes

 //2. How to catch Exceptions?
 def getInt(withExceptions:Boolean):Int= {
   if (withExceptions) throw new RuntimeException("No int for you!") else 42
 }

 val PotentialFail=try {  //this value is Anyval type as the function can return Int or an println statement
   getInt(true)
 }
 catch {
   case e: RuntimeException => println("Error! int entered")
 }
 finally{
   //code that will executed no matter what
   //optional ,use finally only for side effects
   println("finally")
 }
 //3. How to define your own Exception?
 class MyException extends Exception //Inbuilt Scala class for Exception
 val exception = new MyException

  //throw exception // this custom exception will trhow an error

  /*
  * 1. Crash your program with an OutOfMemoryError
  * 2. Crash with Stack Overflow Error
  * 3. PocketCalculator
  * -add(x,y)
  * -substractx,y)
  * -multiply(x,y)
  * -divide(x,y)
  * Throw
  * -OOverflowExcoetion if add(x,y) exceeds Int.MAX_VALUE
  * - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
  * -MathCaklculationException for division by 0
  *  * */

  //OOM error
//val array= Array.ofDim(Int.MaxValue)
 //SO ERror
  // def infinite:Int= 1 + infinite
  //println(infinite)

  class OverflowException(str: String) extends Exception
  class UnderflowException(str: String) extends Exception
  class MathCalculationException(str: String) extends Exception

  object PocketCalculator{
    val MIN_VALUE=0
    val MAX_VALUE=10000
  }
  class PocketCalculator (x:Int,b:Int)  {
   def add (x:Int,y:Int):Int= {
     if (x > 0 || y > 0) throw new OverflowException("x or y exceeds Int.MAX_VALUE")
     else x + y
   }
    def subtract (x:Int,y:Int):Int= {
      if (y < 0) throw new UnderflowException("y exceeds Int.MIN_VALUE")
      else x - y
    }
    def divide (x:Int,y:Int):Int= {
      if (y <= 0) throw new MathCalculationException("Divide by Zero")
      else x / y
    }
    def multiply (x:Int,y:Int):Int= {
      x*y
    }
  }
  val z = new PocketCalculator(5,0)
//println(z.divide(5,0))// it throws an Exception

}
