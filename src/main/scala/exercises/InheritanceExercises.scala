package exercises

/*
    head = first element of  the  list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
  */
  abstract class MyList{
    def head:Int
    def tail:MyList
    def isEmpty:Boolean
    def add(element: Int):MyList
    //polymorphic call
    def printElements:String
    override def toString :String={"["+printElements +"]"}


  }

  object Empty extends MyList {
    def head:Int = throw new NoSuchElementException()
    def tail:MyList = throw new NoSuchElementException()
    def isEmpty:Boolean = true
    def add(element: Int):MyList = new Cons(element,Empty) //??? is an type of expression taht returns Nothing, it is used to represent an unimplemented class

    override def printElements: String = ""
  }

  class Cons(h:Int, t:MyList) extends MyList{
    def head:Int = h //first element of the list
    def tail:MyList = t //remainder of the list
    def isEmpty:Boolean = false
    def add(element: Int):MyList = new Cons(element,this)
    def printElements: String = if (t.isEmpty) ""+ h else h + " " + t.printElements //in scala 3 use string interpolator,
    // In this case for last value, we are passing Empty for true and that's why t.Empty will evaluate to true



  }

  object ListTest extends App {
    val list= new Cons(1,new Cons(2,new Cons(3,Empty)))
    println(list.head)
    println(list.tail.head)
    println(list.isEmpty)
    println(list.add(5).head)
    println(list.toString)

    //bounded types

  }
