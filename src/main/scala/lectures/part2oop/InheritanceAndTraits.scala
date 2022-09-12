package lectures.part2oop

object InheritanceAndTraits extends App{
  //single class inheritance
   class Animal {
    val creatureType="Wild Animal"
    def eat = println("nomnom") //private (not accessible from other classes),protected, no modifier (public)
  }

   class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
    }
    val cat = new Cat
    cat.crunch

  //constructors
  class Person( name: String, age:Int){
    def this(name:String)=this(name,0)
  }
  class Aduilt(name:String, age:Int, idcard:String ) extends Person(name, age) //when extending class with parameters, specify parameters in extends command

  //overriding
  class Dog(dogType: String) extends Animal{
   override val creatureType=dogType
    override def eat =
      super.eat
      println("crunch crunch crunch")
  }

  val dog =new Dog("canine")
  dog.eat
  println(dog.creatureType)
 //type substitution: polymorphism
  val unknownAnimal: Animal = new Dog("K9") // return type is aprent class and called in Dog , method call will go to the most recent call
  unknownAnimal.eat


  //overriding vs overloading (-> supplying different methods with different signatures in same class)

  //Super
 // super.eat //to call parent method from derived class

  //preventing overrides
  //use keyword final -> it will preent derived classes to use eat emthod, 1. use final on memeber , final def eat in Animal class
  //final can be used in class as well
  //2.use fianl on entire class or final class Animal -> it cannot get extended
  //3. seal the class -> if there are only 2 animals , you dont want any one to use animals in extended classes or out of this class file,  you can use sealed

}

