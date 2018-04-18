
object FunctionDemo {
  def main(args: Array[String]): Unit = {
    println(sumVal(x=>x*x*x)(1,3))
    println(sumFun(x=>x*x*x)(1,3))
    def sumVal( x:Int => Int)(a:Int,b:Int): Int = {
      println("someVal is called")
      var sum = 0
      for (i <- a to b){
        sum = sum + x(i)
      }
      return sum
    }

    def sumFun( x:Int => Int): (Int,Int) => Int = {
      println("sumFun is called")
      def sum(a:Int,b:Int): Int = {
        println("sum is called")
        var sum = 0
        for(i <- a to b){
          sum = sum + x(i)
        }
        return sum
      }
      return sum;
    }
  }


}