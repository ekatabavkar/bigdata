package lectures.part2oop

object AbstractDataTypes extends App{
  //abstract, when you want to have a class to contain unimplemented methods
  //abstract class cannot be instantiated
  abstract class Animal{
    val creatureType: String ="animals"
    def eat: Unit
  }
   class Dog extends Animal {
     override val creatureType: String = "Canine"
     def eat:Unit =println("crunch crunch")
   }
  //traits , like abstract classes,
  trait Carnivore{
    def eat(animal:Animal):Unit
    def preferredMeal:String="fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "crocodile"
    def eat:Unit="nononomom"
    def eat(animal: Animal)=print(s"I am crocodile and I eat ${animal.creatureType}")

  }
 val dog = new Dog
 val croc=new Crocodile
 croc.eat(dog)



  /*

  //traits vs abstract classes
  1. traits do not have constructor parameters// scala 3 allows
  2. multiple traits may be inherited by the same class, but only 1 class can be extended
  3. traits describes behavior , abstract class - type of thing
  */
}
