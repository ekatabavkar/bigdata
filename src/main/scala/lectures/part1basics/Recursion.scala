package lectures.part1basics

import java.util.concurrent.atomic.LongAccumulator
import scala.annotation.tailrec

object Recursion  extends App{
  def factorial(n:Int):Int={
    if (n<=1)1
    else {
      println("For computing the factorial of "+n+" I need factorial of "+(n-1))
      val result=n* factorial(n-1)
      println("Computed the factorial of "+n)

      result
    }

  }
  def anotherFactorial(x:Int):BigInt={
    @tailrec
    def factHelper(n:Int, accumulator:BigInt):BigInt={
      if (n<=1) accumulator
      else factHelper((n-1),n * accumulator)
      //Scala does not need to save intermediate result//TAIL RECURSION// use recursvie call as the last expression
      //@tailrec -> to tell Scala compiler to use tail recursion as it optimizes the code
    }
    factHelper(x,1)

  }
  println(factorial(5))
  //println(factorial(5000)) Stack Overflow Error
  println(anotherFactorial(5000)) //returns 0 if the return type is Int, so we change this to BigInt and then run
  println(anotherFactorial(20000)) //returns 0 if the return type is Int, so we change this to BigInt and then run

  /*
  anotherFactorial(10)=facthelper(9,10*1)
                      =facthelper(8,9*10*1)
                      =facthelper(9,8*10*1)
                      =..
                       =facthelper(1,2*3*...8*10*1)

  1*2*3*4*5*6
  * */
 //WHEN YOU NEED LOOPS, USE TAIL RECURSION
 //Any function can be made tail recursive, to make use of Accumulator value
  /*
      Exercises:
      1.  Concatenate a string n times
      2.  IsPrime function tail recursive
      3.  Fibonacci function, tail recursive.
     */
  @tailrec
  def concatenateString(str:String,n:Int,accumulator: String):String={
   if (n<=0) accumulator
   else concatenateString(str,(n-1),str + accumulator)

 }

  println(concatenateString("hello",5,""))
  /*concatenateString("hello",5,"")=concatenateString("hello",4,"hello")
 =concatenateString("hello",4,"hellohello")
 =concatenateString("hello",3,"hellohellohello")
 =concatenateString("hello",2,"hellohellohellohello")
 =concatenateString("hello",1,"hellohellohellohellohello")

*/
  @tailrec
  def fib(n:Int,accumulator: Int):Int={
  if (n==0 || n==1) accumulator
  else fib((n-1),accumulator)

  }
  /*fib
  * 0,1,1,2,3,5,8,11,19
  * 0 1 2 3 4 5 6 7 8
  * */
}
