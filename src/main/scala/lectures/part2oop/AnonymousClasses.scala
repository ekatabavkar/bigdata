package lectures.part2oop

object AnonymousClasses extends App {
 abstract class Animal{
   def eat:Unit
 }
//anonymous class
  val funnyAnimal:Animal =new Animal {
   override def eat: Unit =println("hahahaha")

  }
  println(funnyAnimal.getClass )
/*
  equivalent with
class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit =println("hahahaha")
  }
  val funnyAnimal:Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.eat )

  * */

  class Person(name:String){
    def sayHi:Unit=println(s"Hi my name is $name how can I help?")
  }

  val jim:Person= new Person("Jim"){
    override def sayHi: Unit = println(s"Hi my name is Jim. how can I be of service?")
  }

 // We can instantiate types and over ride fields aor methods on the spot
  //Rules
  //pass in required constructyore arguments
  //implement all abstract fields and methods
  //works for traits and classes
 def superAdd= (x:Int) =>(y:Int) => x + y
 println(superAdd (3)(4))

}
