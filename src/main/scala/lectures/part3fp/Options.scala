package lectures.part3fp

object Options extends App{

  //Option is wrapper for a value that might be present or not.
  //Some wraps a concrete value
  //None is a singleton for absent values
  val myFirstOption:Option[Int] = Some(4)
  val noOption:Option[Int]=None

  println(myFirstOption)
  def unsafeMethod:String = null
  //val result = Some(unsafeMethod) // WRONG, Some should always return something not null
  val result = Option(unsafeMethod) //Some or None. The whole point of Optioons is that we should not do null checks ourselves
  println(result)

  //chained methods
  def backupMethod:String = "A valid result"
  val chainedResult = Option(unsafeMethod).getOrElse(Option(backupMethod))
  println(chainedResult)

  //DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse(betterBackupMethod())
  println( betterChainedResult )

  //functions on Options
  println(myFirstOption.isEmpty)
  println((myFirstOption.get)) //UNSAFE TO DO THIS

  //map.flatMap,filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x=>x>100))
  println(myFirstOption.flatMap(x => Option(x * 100)) )

   //for comprehensions

}
