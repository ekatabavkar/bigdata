package lectures.part2oop

object MethodNotations extends App{
class Person(val name:String, favoriteMovie:String, val age:Int=0){
  def likes(movie:String)=movie==favoriteMovie
  def +(person: Person)=s"${this.name} likes to hangout with ${person.name}"
  def +(nickname:String):Person= new Person(s"$name ($nickname)", favoriteMovie)
  def unary_! : String =s"$name, what the heck?"
  def unary_+ :Person =new Person(name,favoriteMovie,age+1)
  def isAlive : Boolean= true
  def learns(thing:String) = s"$name learns $thing"
  def learnsScala:String=learns("Scala1")
  def apply(): String=s"Hi My name is $name and I like $favoriteMovie"//parantheses are IMP
  def apply(x:Int)=s"${this.name} watched $favoriteMovie $x times"
}

  //infix notation
  val mary=new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")


  //Operators in Scala
  val tom=new Person("Tom","Fight club")
  println(mary.+(tom))
  println( mary + tom)
  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS in SCALA ARE METHODS
 //AKKA actors have ! ?

  //prefix ,  //unary
  val x = -1 //-1 is equivalent of unary _-, unary_ prefix is only applicable for !, ~ ,-, +
  val y = 1.unary_-
  println(!mary)
  println(mary.unary_!)

  //postfix
  //functions that do not have any parameters ONLY can be used in post fix notation
  println(mary.isAlive)
  println(mary isAlive)


  //apply()
  println(mary.apply())
  println(mary())

 //exercise
  println((mary + "the rockstar").apply())
  println((+mary).age)
  println(mary learns "Scala with ZIO")
  println(mary.learnsScala) //postfix
  println(mary.apply(2))
  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

}
