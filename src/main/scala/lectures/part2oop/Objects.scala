package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY("static")
  object Person {//type + its only instance
    //CLASS LEVEL FUNCTIONALITY
    val N_EYES: Int = 2
    def canFly:Boolean = false
    //vals, vars in object, but cannopt define parameters in object

    //factory method are defined in singleton objects like below, with this you can directly called ,
    def apply(mother:Person, father:Person):Person=new Person("Bobbie")

  }

  class Person(val name:String){
    //INSTANCE LEVEL FUNCTIONALITY

  }
  //COMPANIONS , object and class ahve the same name

  // Scala object =SINGLETON INSTANCE
  val mary =Person
  val jim=Person
  println(mary==jim)
  //mary and Jim point to same instance. as it is singleton object Person

  val mary1=new Person("MAry")
  val mary2=new Person(name="John")
  println(mary1==mary2) // but here the refernce is different, as these are 2 seperate instances of class Person

  println(Person.N_EYES)
  println(Person.canFly)
  //WIDELY USED
 //val bobbie=Person.from(mary,jim)
  // or
  //val bobbie=Person.apply(mary,jim)
  //or
 // val bobbie = Person(mary,jim)

}
