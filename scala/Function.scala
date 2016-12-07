
class Function {
  
  def modN(n: Int)(x: Int) = 
    ((x % n) == 0)
    
  def modN(n: Long)(x: Long) = 
    ((x % n) == 0)
    
  def modN(n: Double)(x: Double) = 
    ((x % n) == 0)
    
  def modN(n: Int, m: Int)(x: Int) = 
    (((x % n) == 0) || ((x % m) == 0))
    
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
    
  def sum(xs: List[Int]): Int = {
    xs match {
      case x :: tail => x + sum(tail)
      case Nil => 0
    }
  } 
}
