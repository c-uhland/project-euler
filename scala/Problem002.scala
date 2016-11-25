
/**
 * Each new term in the Fibonacci sequence is generated by adding the 
 * previous two terms. By starting with 1 and 2, 
 * the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not 
 * exceed four million, find the sum of the even-valued terms.
 * 
 */
object Problem002 {
  
  def main(args: Array[String]): Unit = {
    
    var result = sum(filter(fibList(), modN(2)))
    println(result)
  }
  
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
  
  def modN(n: Int)(x: Int) = 
    ((x % n) == 0)

  def sum(xs: List[Int]): Int = {
    xs match {
      case x :: tail => x + sum(tail)
      case Nil => 0
    }
  }
  
  def fibList() : List[Int] = {
    var list = List(1,2)
    while (list.last < 4000000) {
      list = clacFib(list)
    }   
    
    list
  }
  
  def clacFib(xs: List[Int]) : List[Int] = {
    xs ::: List(xs.last + xs.reverse.tail.head)
  }
}