package lectures.part2oop

object OOPBasics extends App {
  val person = new Person("John",30)
  println(person.age)
  // println(p.name) this will error out because name is a parameter NOT a field. To promote a parameter to field, use val or var
  println(person.greet("Daniel"))
  println(person.greet())

  val author=new Writer("Charles","Dickens",1812)
  val imposter=new Writer("Charles","Dickens",1812)
  val novel=new Novel("Great Expectations",1831,author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.print
  counter.inc(5).print
  counter.dec(5).print

}

//CLASS PARAMETERS ARE NOT FIELDS
//constructor (name:String, val age:Int) is used to construct the instance
class Person(name:String, val age:Int) {
  //body //fields //members
  val x = 2 //all variables declared in body can be accessed . println(person.x)
  println(1 + 3) //this side effect will get executde everytime an object is created

  //method
  def greet(name: String) = println(s"Hello ${this.name}. My name is $name")

  //overloading =
  def greet() = println(s"Hi $name")
  //another function with same name def greet() this is not allowed. In overloading function name should be same, but parameters should be different.

  //multiple constructors
  def this(name: String) = this(name, 0) //to make age parameter defaulted to 0

  def this() = this("John Doe") //this will default the name, but this is not used as you cand efaulted the argumement while defining the class class Person(name:String="John Doe", val age:Int=0)
}
  //Exercises

  /*
  Novel and a Writer
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */
  class Writer(firstName:String,surName:String, val yearOfBirth:Int) {
    def fullName() = firstName + " " + surName
  }

  class Novel(name: String, yearOfRelease:Int,author:Writer){
    def authorAge()=(yearOfRelease-author.yearOfBirth)
    def isWrittenBy(author:Writer)=author==this.author
    def copy(newYear:Int):Novel=new Novel(name,newYear,author)
  }
  /*
    Counter class
      - receives an int value
      - method current count
      - method to increment/decrement => new Counter
      - overload inc/dec to receive an amount
   */


 class  Counter(val count:Int = 0) {
   def inc() = {
     println("incrementing")
     new Counter(count + 1) //Immutability whenever you need to modify an instance you create a new instance
   }
   //in case you want to log every time a value is incremented , you need to follow recursion

   def inc(n: Int):Counter = {
     if (n <= 0) this
     else inc.inc(n-1)
      //Immutability whenever you need to modify an instance you create a new instance
   }

   def dec() = {
     println("decrementing");
     new Counter(count - 1)
   }

   def dec(n: Int) :Counter= {
     if (n <= 0) this
     else dec.dec(n-1)
   }

   def print = println(count)
   }











