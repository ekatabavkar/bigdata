package playground

object rough extends App {
  val a = '?'
  val string = "assf         hmmmmmmm..."
  println(string.matches("^.*[a-zA-Z]+.*"))
  println(string.trim)

  //println(string.isUpper())
  println(string.head)
  println(string.tail)

  println('a' == "a")

  def distance(str1: String, str2: String): Option[Int] = {

    def compare(a: String, b: String, acc: Int): Int = {
      if (a.isEmpty) acc
      else {
        compare(a.tail, b.tail, acc + {
          if (a.head == b.head) 1 else 0
        })
      }
    }

    if (str1.length == str2.length)
      Option(compare(str1, str2, 0))
    else None

  }

println(distance("D","E"))

  println("ABC".zip("CDS"))
  val aMap= Map(1 -> Seq("A","E"), 2->Seq("B","C","D") )
  val aList =List(List(1,2,3), List(4,5,6))
  println(aList.flatten)

  println(aMap.map(x=>x._2.map( (y:String) => y.toLowerCase -> x._1)).flatten.toMap )


  case class Triangle(a:Double,b:Double,c:Double) {
    def isTriangle = (a>0 & b>0 & c>0 ) && ( ( a + b >= c) && (a +c >= b) && ( b + c >= a) )
    def equilateral= isTriangle && (a==b && b==c)
    def isosceles = isTriangle && ( a==b  || b==c || a==c )
    def scalene = isTriangle &&  (a!=b && b!=c)
  }

  println(Triangle(10, 4, 4).isTriangle )


  def recite(n: Int, repeat: Int): String = {
    def recRecite(n: Int, repeat: Int, acc: String): String = {
      if (repeat ==0 ) acc
      else
      recRecite(n - 1, repeat - 1, acc + (n match {
        case n if (n > 2) => s"${n} bottles of beer on the wall, ${n} bottles of beer.\nTake one down and pass it around, " + {n-1}.toString + s" bottles of beer on the wall.\n"
        case n if (n==2) => s"$n bottles of beer on the wall, ${n} bottles of beer.\nTake one down and pass it around, ${n-1} bottle of beer on the wall.\n"
        case n if (n==1) => s"$n bottle of beer on the wall, $n bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        case n if (n==0)  => s"No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
      }) )

    }

    recRecite(n, repeat, "")
  }
  println(recite(99,100))
  println(s"{99-1}")
  println("99 bottles of beer on the wall, 99 bottles of beer.\nTake one down and pass it around, 98 bottles of beer on the wall.\n" == "99 bottles of beer on the wall, 99 bottles of beer.\nTake one down and pass it around, 98 bottles of beer on the wall.\n")



}


