package lectures.part1basics

object CBNvsCBV extends App{
  def calledByValue(x:Long)={
    println("by value",x)
    println("by value",x)
  }
  def calledByName(x: => Long)={
    println("by name",x)
    println("by name",x)
  }
  calledByValue(System.nanoTime()) // this value is computed before the function is called, same value used every where
  calledByName(System.nanoTime())// this expression is computed only when the expression is called everytime, => delays the evaluation of expression,

 def infinite():Int=1+ infinite()
  def printFirst(x:Int, y: => Int ):Unit= println(x)

//  printFirst(infinite(),34)
  printFirst(25,infinite())
}
