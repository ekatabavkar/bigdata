package lectures.part4pm

import scala.util.{Failure, Success, Try}

/**
 * try catch  -> issue,
 * mutlple /nested trys's make the code hard to follow
 * we can't chain multiple operatiosn are prone to failure
 *
 *
 * A Try is a wrapper for a computation that might fail or not
 * wrap failed computations
 * wrap succeeded computations
 * */
object HandlingFailure extends App{

  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE "))

  println(aSuccess)
  println(aFailure)
  def unsafeMethod():String = throw new RuntimeException("NO STRING FOR YOU BUSTER")
  val potentialFailure = Try (unsafeMethod())
  println(potentialFailure)

  //syntax sugar
  val anotherPotentialFailure = {
    //codeblock that might throw an exception
     }
  //utilities

  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  //orELse
  def backupMethod():String ="A vlid result "
  println(Try(unsafeMethod()).orElse(Try(backupMethod())))

  //if you design the api
  def betterUnsafeMethid():Try[String] = Failure(new RuntimeException())
  def betterBackupMethod():Try[String] = Success(s"A valid success")

  println (betterUnsafeMethid() orElse betterBackupMethod())


  //map,flatmap,filter

  println(aSuccess.map(_ *2))
  println(aSuccess.flatMap(x=>Success(x*10)))
  println(aSuccess.filter(_ > 10))
}
