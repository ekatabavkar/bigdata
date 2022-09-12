package lectures.part1basics

object Functions extends App {
  def ParameterlessFunction ()=42
  println(ParameterlessFunction())
  //From scala 3, parameter less functions need to be invoked with empty braces()

  def greeting(name: String, age:Int)=println(s"Hi, my name is $name and I am $age years old.")
  greeting("Ekata",25)
  def greeting1(name: String, age:Int):String="Hi, my name is"+name +"and I am "+age+" years old."
  greeting1("Ekata",30)

  def factorial (n: Int):Int={
    if (n==1) 1
    else n*factorial(n-1)
  }
  factorial(5)

  def fib(n:Int):Int={
    if (n==0 || n==1) n
    else fib(n-1)+fib(n-2)
  }

/*  def isPrime(n:Int):Boolean={

  }
*/
  fib(5)

  //def isPrime(n:Int):

}
