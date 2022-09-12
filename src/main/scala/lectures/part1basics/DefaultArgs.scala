package lectures.part1basics

object DefaultArgs extends App {
def trfactorial(n:Int,accum:Int):Int={
      if (n<=1) accum
      else trfactorial((n-1),n * accum)
    }
  //in this case, accum, will always be 1,dso , we can assign default value
  def trfactorial1(n:Int,accum:Int=1):Int={
    if (n<=1) accum
    else trfactorial((n-1),n * accum)
  }
  val fact10=trfactorial1(10)

  //we cannot omit default argument if it not the last parameter, so , we name them, so that the compiler knows
  def savePicture(format:String="jpg", height:Int, width:Int)=println("saving picture")
 // savePicture(800,600) this will treat 800 as first parameter
  savePicture(height=800,width=600)
  savePicture(width=700, height=566)//order can be changed

}
