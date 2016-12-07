
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem_001  {

  def main(args: Array[String]): Unit = {
    var help = new Function()
    
    var list = (1 to 999).toList
    var modList = help.filter(list, help.modN(3, 5))
    var result = help.sum(modList)
    
    println(result)
  }
}
