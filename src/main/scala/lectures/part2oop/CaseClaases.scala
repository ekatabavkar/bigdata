package lectures.part2oop

object CaseClaases extends App{

  case class Person(name:String,age:Int)

  //1. no need to use the new keyword to create instance of the class
  val mary = Person("Mary",42)

  //2. has companion object enabled and hence, we can use apply method inbuilt
  println(mary)

  //3. builtin equals and hashcode method OOTB
  val jim = Person("Mary",42)
  println(mary==jim)

  //4.has copy method
  val john =mary.copy(age=45)
println(john)

  //5. sensible to string
  println(john.toString)//println(instance)==println(instance.toString)

 // 6. class parameters are field, no need to declare val or var
  println(john.name)

 //7. CCs are serializable . Very useful when working Akka in which lot of data is transferred over the network
  case object UnitedKingdon{
   def name : String = "The UK of GB ad NI"
 }
  //benefits similar to case class except that it does not have companion object as it  itself is an object
}
