package lectures.part3fp

import scala.util.Random

object Sequences extends App{
  //Seq
  /*
  -have a well defined order
  -can be indexed
  supports various operators like apply,iterator,length, reversem for indexing and iterating
  concatenation, appending, prepening, grouping, sorting zipping, searching, slicing,
*/
 val aSequence = Seq(1,7,5,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(4,4,5)) //concatenation operator ++
  println(aSequence.sorted)

 //Ranges
  val aRange: Seq[Int] = 1 until 10 //1 to 10
  aRange.foreach(x => println(x))
  (1 to 10).map(x=>println("hello"))

    //List
  val aList = List(1,2,3)
  //val prepended = 42 +: aList :+ 45 //not support in scala 2.12 but ion 2.13
  val prepended = 42 :: List(1,2,4)
 println(prepended)
  val apples5 = List.fill(5)("apple")
  println(apples5)

  //Array
  val numbers = Array(1,23,4,5)
  val threeElements = Array.ofDim[Boolean](3) //for boolean , it will be false, for int, it will be zero, for string and object it will be null
  println(threeElements)
  for (elem <- threeElements) {println(elem)}
  //mutation
  numbers(2)=0 //syntactic sugar for numbers.update(2,0)
  println(numbers.mkString(" "))
  //arrays and seq
  val numbersSeq:Seq[Int] = numbers //implicit conversion from array to Sequence
  println(numbersSeq)


  //vectors
  def vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vectors vs lists
 val maxRuns=1000
 val maxCapacity=10000

 def getWriteTime(collection: Seq[Int]) ={
  val r = new Random
  val times = for (i <- 1 to maxRuns)yield {
   val systemTime= System.nanoTime()
   collection.updated(r.nextInt(maxCapacity),r.nextInt)
    System.nanoTime() - systemTime
  }
  (times.sum * 1.0)/maxRuns
    }

 val numbersList = (1 to maxCapacity).toList
 val numbersVector = (1 to maxCapacity).toVector

 println(getWriteTime(numbersList)) //take more time 9 milli seconds
 println(getWriteTime(numbersVector)) // takes lessor time 4 micro seconds, Vector is the default implementaion of Sequnece

}
