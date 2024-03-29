package lectures.part3fp

object HOFsCurries extends App {

  def superFunction: (Int, (String => (Int => String)), Int, (String => Boolean)) = ???

  //higher order functions  -> takes functions as parameters  and returns functions as a list

  //map,flatMap, filter in MyList

  //function that applies a function n time over a value x
  //nTimes(f,n,x)
  //nTimes(f, 3, x) = f(f(f(x) =nTimes(f, 2, f(f(x)))
  //nTimes(f, 2, x)

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  }

  val plusOne = (x: Int) => x + 1
  println(nTimes((x: Int) => x * 2, 5, 10))
  println(nTimes(plusOne, 10, 1))

  //ntb(f,n) = x => f(f(f(f...(x)) .. return function which then can be later applied with x
  // nTimesBetter(plusOne, 10) ->
  //increment10 = nTimesBetter(plusOne,10) -> plusOne(plusOne(....plusOne(10))
  //val y = increment(10)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x)) //nTimesBetter(f,n-1) returns a function and that function will be applied to f(x)
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  //curried functions

  val superAdder = (x: Int) => (y: Int) => x + y
  val adder3 = superAdder(3) // y => x+ y
  println(adder3(10))
  println(superAdder(3)(4))

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(d: Double) = c.format(d)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val precisedFormat: (Double => String) = curriedFormatter("$10,.8f") //pass types, for smaller functions otherwise complier will fail
  println(standardFormat(Math.PI))
  println(precisedFormat(Math.PI))
  /*
     1.  Expand MyList
         - foreach method A => Unit
           [1,2,3].foreach(x => println(x))
         - sort function ((A, A) => Int) => MyList
           [1,2,3].sort((x, y) => y - x) => [3,2,1]
         - zipWith (list, (A, A) => B) => MyList[B]
           [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]
         - fold(start)(function) => a value
           [1,2,3].fold(0)(x + y) = 6
     2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
         fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
     3.  compose(f,g) => x => f(g(x))
         andThen(f,g) => x => g(f(x))
    */


}
