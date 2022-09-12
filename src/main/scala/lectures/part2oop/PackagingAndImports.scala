package lectures.part2oop
import playground.{Cinderella => Princess, PrinceCharming} //you can also use import platground._ , but as a best practice,use {} if you are using only few classes from a apackage
import java.util.Date
import java.sql.{Date=>SqlDate}


object PackagingAndImports extends App{

  //package is bunch of definitions grouped under a same name.

  //[ackage members are accessible by thie simple name
  val writer = new Writer("Daniel" , "RockTheJVM", 2018)

  //import the package if the class is not in the same package or use fully qualified name
  val princess = new Princess //playground.Cinderella =full qualifed name
  //packages are in hierarchy, packages mirror the file structure
  //matching folder structure

  //package object -> methids and constants outside classes like universal methods or constants
 //created package object in the same folder. package object can be only 1 in 1 package
 //the naming convention is package.scala
 //inside package object we can define methods , constants
 sayHello
  println(SPEED_OF_LIGHT)
  //imports

  val prince = new PrinceCharming

  // incase of packages with duplicate classes
   //1.  use FQ names
  //2. or use aliasing
  val date = new Date
  val sqlDate= new SqlDate(2018,5,28)

  //default imports
  //java.lang
  //scala -Int, Nothing, Function
  //scala - Pref - println, ???


}


//3.

