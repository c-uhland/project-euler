/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem_001  {
  def main(args: Array[String]) : Unit = {
    
    var list = (1 to 999).toList
    var modList = filter(list, modN(3, 5))
    var result = sum(modList)
    
    println(result)
  }
  
  
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
  
  def modN(n: Int, m: Int)(x: Int) = 
    (((x % n) == 0) || ((x % m) == 0))
  
  def sum(xs: List[Int]): Int = {
    xs match {
      case x :: tail => x + sum(tail)
      case Nil => 0
    }
  } 
}
