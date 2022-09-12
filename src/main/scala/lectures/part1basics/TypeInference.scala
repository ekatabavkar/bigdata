package lectures.part1basics

object TypeInference {
val message="Hello, world!"//String
val x=2
val y=x+" hi" //compiler is able to infer type -> Int+ String=String
def succ(x:Int)=x+1 // here the compiler figures out the return type as Int because x is Int
//val x:Int="Hello, world!"  -> will throw a type mis match error
/**
  def factorial (n:Int)=
    if(n<=0)1
    else n*factorial(n-1)
 //This will error out as compiler cannot figure out the return type of > else n*factorial(n-1)
It knows n is int , but factorial(n-1) does not have a return type, hence it will throw an error
*/
}

