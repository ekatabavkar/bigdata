package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "the Two"
    case 3 => "the three"
    case _ => "Anything else" // _ WILD CARD for anything else
  }

  println(x)
  println(description)

  //1. DECOMPOSE VALUES / CASE CLASS
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and my age is $a. I cannot drink in th US" //with if guard
    case Person(n, a) => s"Hi my name is $n and my age is $a" // extractor pattern Person(n,a) for case class
    case _ => "I dont know who I am"
  }
  println(greeting)

  /*
  *  1. cases are matched in order
  *  2. what if no cases match? matchError
  *  3. type pf Patterm matching expression? unified type of all the types in all the cases
  *  4. PM works really well with case classes
  * */

  // PM on sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Cannine")

  animal match {
    case Dog(somebreed) => println(s"Hi I am a Dog of type $somebreed breed")
  }
  //compiler will throw an error in this case as case calss for PArrot has not been covered

  //DO NOT USE THIS
  //match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  // not even this

  val isEvenCond = if (x % 2 == 0) true else false //WHY???
  val isEvenNormal = x % 2 == 0

  /*
     Exercise
      simple function uses PM
      takes an Expr => human readable form
      Sum(Number(2), Number(3)) => 2 + 3
      Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
      Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
      Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
    */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  /*
  def show(exp: Expr): String = {

    exp match {
      case Number(n) => s"$n"
      case Sum(e1, e2) => show(e1) + " + " + show(e2)
      case Prod(e1, e2) => {
        def maybeShowParanthese(exp: Expr) = exp match {
          case Prod (_,_) => show(exp)
          case Number(_) => show(exp)
          case _ => "(" + show(exp)+ ")"
        }

      }
    }
  }

   */
}