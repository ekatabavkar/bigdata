package exercises


/*
    head = first element of  the  list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
  */
/*
* 1. Create a generic trait MyPredicate[T] with a little method test(T) =>Boolean
* 2. Generic trait MyTransformer[A,B] // small method to convert a value of type A to a type B
* 3. MyList:
* -map(transformer) => myList
* - filter(predicate) => MyList
* -flatMap (transformer
* 4. class EvenPredicate extends MyPredicate[Int]
* 5. class StringToIntTransformer  extends MyTransformer[String, Int]
*
* [1,2,3].map(n * 2) = [2, 4, 6]
* [1, 2,3,4].filer(n % 2) = [2, 4]
* [1, 2, 3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
* */

/*
  1.  Expand MyList
      - foreach method A => Unit
        [1,2,3].foreach(x => println(x))
      - sort function ((A, A) => Int) => MyList
        [1,2,3].sort((x, y) => y - x) => [3,2,1]
        inputList=[1,4, 3 ,6,7]
        sortedList -> s -> []
        unsortedList -> u ->
        s ->head ->1
        u -> tail -> 5,2,4,7
        compare head , with tail head
        if tail.head> head, tail

        //python
        for i, num in enumerate(inputList): //(0,1), (1,5), (2,2),(3,3)
         if i==0:
               sortedList.append(inputList[num]) //[1],
         else:
             for j, snum in enumerate(sortedList): [1],[5,1],[5,2,1]
                if num> snum:  //5>1 -> [1], 2>1 -> [5,1], j=1
                   sortedList.insert(j, num)
                else:
                   continue
         return sortedList










      - zipWith (list, (A, A) => B) => MyList[B]
        [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]
      - fold(start)(function) => a value
        [1,2,3].fold(0)(x + y) = 6
  2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
      fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
  3.  compose(f,g) => x => f(g(x))
      andThen(f,g) => x => g(f(x))
 */

abstract class MyGList[+A] {
  def head:A
  def tail:MyGList[A]
  def isEmpty:Boolean
  def add[B >: A](element: B):MyGList[B]

  //polymorphic call
  def printElements:String
  override def toString :String={"["+printElements +"]"}
  def map[B](transform: MyTransformer[A,B]):MyGList[B]
  def filter(predicate:MyPredicate[A]):MyGList[A]
  def flatMap[B](transform: MyTransformer[A,MyGList[B]]):MyGList[B]

  //concatenation
  def ++ [B >: A ](list: MyGList[B]) : MyGList[B]

  //hofs
  def foreach(f: A => Unit ):Unit
 // def sort(compare:(A,A)=>Int):MyGList[A]

}

case object GEmpty extends MyGList[Nothing] {
  def head:Nothing = throw new NoSuchElementException()
  def tail:MyGList[Nothing]= throw new NoSuchElementException()
  def isEmpty:Boolean = true
  def add[B >: Nothing](element: B):MyGList[B] = new GCons(element,GEmpty) //??? is an type of expression taht returns Nothing, it is used to represent an unimplemented class
  override def printElements: String = ""
  def map[B](transform: MyTransformer[Nothing,B]):MyGList[B]=GEmpty
  def filter(predicate:MyPredicate[Nothing]):MyGList[Nothing]=GEmpty
  def flatMap[B](transform: MyTransformer[Nothing,MyGList[B]]):MyGList[B]=GEmpty
  def ++ [B >: Nothing ](list: MyGList[B]) : MyGList[B] = list
  //hofs
  def foreach(f: Nothing => Unit) = ()
  //def sort(compare:(Nothing,Nothing)=>Int):MyGList[Nothing]=GEmpty


}

case class GCons[+A](h:A, t:MyGList[A]) extends MyGList[A]{
  def head:A = h //first element of the list
  def tail:MyGList[A]= t //remainder of the list
  def isEmpty:Boolean = false
  def add[B >: A](element: B):MyGList[B]= new GCons(element,this)
  def printElements: String = if (t.isEmpty) ""+ h else h + " " + t.printElements //in scala 3 use string interpolator,
  // In this case for last value, we are passing Empty for true and that's why t.Empty will evaluate to true


  /*
*  [1,2,3].map( n * 2 ) =>
*  new GCons(transformer.transform(h),t.map(transformer))
*  new GCons(2 ,t.map(transformer)) // override def transform(a: Int): Int = a * 2
*  new GCons(2 ,new GCons(transformer.transform(h),t.map(transformer)) )
* new GCons(2 ,new GCons(4, t.map(transformer)) )  // override def transform(a: Int): Int = a * 2

* new GCons(2 ,new GCons(4, new GCons(transformer.transform(h),t.map(transformer)) )
* new GCons(2 ,new GCons(4, new GCons(6,t.map(transformer)) ) // override def transform(a: Int): Int = a * 2
* new GCons(2 ,new GCons(4, new GCons(6,GEmpty.map(transformer) )
* new GCons(2 ,new GCons(4, new GCons(6,GEmpty) ) // override def transform(a: Int): Int = a * 2

.  * */
  def map[B](transformer: MyTransformer[A,B]):MyGList[B]= {
    new GCons(transformer.transform(h),t.map(transformer))
  }
  /*
* [1,2,3].filter(n % 2==0)
* if predicate.test(h)  //override def test(t: Int): Boolean = t % 2 ==0
*  1 % 2 !=0
*  t.filter(predicate)
* 2% 2==0
* new GCons(2, t.filter(predicate))
* 3 % 2!=0  //override def test(t: Int): Boolean = t % 2 ==0
* new GCons(2, GEmpty.filter(predicate)
*
* */
  def filter(predicate:MyPredicate[A]):MyGList[A]={
   if(predicate.test(h)) new GCons(h, t.filter(predicate))
   else t.filter(predicate)
  }

  /* [1,2] ++ [3,4,5]
  * new GCons(1,[2] ++ [3,4,5])
  * new GCons(1,2,GEmpty ++ [3,4,5])
  *  new GCons(1,2,3,4,5)
  * */
  def ++ [B >: A ](list: MyGList[B]) : MyGList[B] = new GCons[B](h, t ++ list)

  /*[1, 2, 3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
  *  1 -> 1, 2
  *  2 -> 2, 3
  *  3 -> 3, 4
  * */
  def flatMap[B](transformer: MyTransformer[A,MyGList[B]]):MyGList[B]= {
  transformer.transform(h) ++ t.flatMap(transformer)
    }
 //hofs
  def foreach(f:A => Unit):Unit ={
  f(h)
  t.foreach(f)
  }

 // def sort(compare:(A,A)=>Int):MyGList[A] ={}




}
trait MyPredicate[-T] {
  def test(t:T):Boolean
}
trait MyTransformer[-A,B] {
  def transform(a:A):B
}

class EvenPredicate extends MyPredicate[Int] {
  def test(t:Int) :Boolean ={
    if (t%2 == 0) true
    else false
  }

}

class StringToIntTransformer  extends MyTransformer[String, Int] {
  def transform(a: String): Int = a.toInt

}

object GenericListTest extends App {
  val listOfIntegers:MyGList[Int] = new GCons(1,new GCons(2,new GCons(3,GEmpty)))
  val clonelistOfIntegers:MyGList[Int] = new GCons(1,new GCons(2,new GCons(3,GEmpty)))
  val listStr: MyGList[String]=new GCons("one",new GCons("two",new GCons("three",GEmpty)))
  println(listOfIntegers.head)
  println(listOfIntegers.tail.head)
  println(listOfIntegers.isEmpty)
  println(listOfIntegers.add(5).head)
  println(listOfIntegers.toString)

  println(listStr.head)
  println(listStr.tail.head)
  println(listStr.isEmpty)
  println(listStr.add(5).head)
  println(listStr.toString)


/* using annonymous class -- OOP style)
  println(listOfIntegers.map(new MyTransformer[Int, Int]{
    override def transform(a: Int): Int = a * 2  }   ) )


  println(listOfIntegers.filter (new MyPredicate[Int] {
    override def test(t: Int): Boolean = t % 2 ==0
  }).toString)

  println( listOfIntegers.flatMap(new MyTransformer[Int, MyGList[Int]] {
  override def transform( a: Int):MyGList[Int] = new GCons(a, new GCons(a + 1, GEmpty))
  }).toString)
*/

  /* using annonymous class -- FP style)*/
  println(listOfIntegers.map(_ * 2).toString )


  println(listOfIntegers.filter (_ % 2 ==0).toString)

  //PLEASE REVISIT THIS
  //println( listOfIntegers.flatMap(a => new GCons(a, new GCons(a + 1, GEmpty)) ).toString)

  //case class , after changing empty and cons class to case class
 println(listOfIntegers ==clonelistOfIntegers )

  //hofs
  println(listOfIntegers.foreach(println).toString)

  val combination= for {
    n <- listOfIntegers
    s <- listStr
  } yield {n+"-"+s}
  println(combination)
}
