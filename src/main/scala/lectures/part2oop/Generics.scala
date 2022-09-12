package lectures.part2oop

import com.sun.org.glassfish.external.amx.BootAMXMBean


object Generics extends App{

   class MyList[A] {
   //use the type A
     def add[B >: A](element: B):MyList[B] = ???
     /*
     A -> Cat
     B-> Dog or Animal
     */
   }

  class MyMap [Key, Value]

  val listOfIntegers = new MyList[Int]
  val  listOfStrings = new MyList[String]

 //OBJECTS CANNOT BE TYPE PARAMETERIZED

  //generic methods
  object MyList{
   def empty[A]: MyList[A] = ???
    }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
 //Does  LIST OF CATS ALSO EXTENDS LIST OF ANIMALS??

  //YES, List[Cat] extends List[animal]
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]

  //can I also add animalList.add(new Dog) ??? what shoudl it return? list of Cat or list of Dor list of animals?
  // In theory yes, we can return Dog but that would pollute Cat list, since animalList is list of Cats, and not list of animals
  // In this case we should use

  //NO=INVARIANCE
  class InvariantList[A]
  val invariantAnimalList1:InvariantList[Animal]= new InvariantList[Animal]

 //Hell No, ContraVariant
 class ContraVariantList[-A]
  val contraVariantList:ContraVariantList[Cat]=new ContraVariantList[Animal] //this relationship is exactly opposite

  //instead of Covariant list , let's crete class of trainer,
  class Trainer[-A]
  val trainer:Trainer[Cat]=new Trainer[Animal] //now it makes sense, trainer can train cat, dog, etc.

  //bounded types
  class Cage[A <: Animal](animal: A)  //class cage only have types of subtype of animals

  val cage = new Cage(new Cat)


  class Car
  /*
  val newCage = new Cage(new Car)

  this will throw an error
  inferred type arguments [lectures.part2oop.Generics.Car] do not conform to class Cage's type parameter bounds [A <: lectures.part2oop.Generics.Animal]
  val newCage = new Cage(new Car)
*/
 //bounded types solved variance problem



}
