package lectures.part4pm

import exercises.{GCons, GEmpty, MyGList}

object AllThePatterns extends App{
  // 1 - constants

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE SCALA"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"

  }

  //2 match anything
  //2.1 wild card

  val matchAnything = x match {
    case _ => "Return anything"
  }

   //2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

   //2.3 tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case(something, 2) => s"I've found $something"
    }

  val nestedTuple =(1,(2,3))

  val matchANestedTuple = nestedTuple match {
    case (1,(v,23)) =>  s"$v" //v is a variable here
    case _ =>
  }

  //PMS can be nested!

  //4 - case classes - constructor pattern
  val aList: MyGList[Int] = GCons(1,GCons(2,GEmpty))

  val matchAList= aList match {
    case GEmpty =>
    case GCons (head, GCons(subhead, subtail)) =>
  }

  //5 - list patterns
  val aStandardList = List (1,2,3,4,45)
  val matchAStandardList = aStandardList match{
    case List (1,_,_,_,_) => //extract adavanced
    case List(1,_*) => //arbitarary length
    case 1:: List(_) => //infix pattern
    case List(1,2,3,4) :+ 45  => //infix pattern
  }

  // 6 - type specifiers
  val unknown : Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifiers
    case _ =>
  }

  //7 name bindinh
  val nameBindingMatch = aList match{
    case nameNotEmpty @ GCons(_, _) => //assign a name to the pattern - name binding
    case GCons(1,rest @ GCons(_,GEmpty)) => //name binding inside nested pattern
    case _ =>
  }

  //8 - multi - patterns
  val multipattern = aList match {
    case GEmpty | GCons(0,_) => //comopund oattern , or OR multi pattern, this or this
    case _ =>

  }

  //9 - if guards
  val secondElementSpecial = aList match{
    case GCons(_,GCons(specialElement,_)) if specialElement % 2 ==0 =>
    case _ =>

  }

  //ALL
  /*Questions
  *
  *
  * */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case alistOfString : List[String] => "a list of Strings"
    case alistofNumbers : List[Int] => "a list of Integers"
    case _ => "anything else"
  }
  //this returns a list of strings , as scala works on jvm , and jvm offers backward compatbility,
  // and in ewarlier version, it treats alistOfString :List, hence its matches the first condition

  println(numbersMatch)
}
