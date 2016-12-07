

class SieveOfEratosthenes(in:Double) {
  var help = new Function()
  var max = scala.math.sqrt(in)
  
  
  def buildPrimes() = {
    var range2 = 2D to max by 2D
    var primes = List(2D)
    
     
    var range3 = 3D to max by 3D
    primes = primes :+ 3D
    
    var range5 = 5D to max by 5D
    primes = primes :+ 5D
    
    var range23 = (range2 ++ range3).distinct
    var intersect = (range23 ++ range5).distinct
    var p = primes.last 
    var sqrtOfMax = scala.math.sqrt(max)
    
    
    while(p < sqrtOfMax){
      p = p + 2
      while (!isPrime(p, primes) && ( !intersect.contains(p) || !primes.contains(p))) {
        p = p + 2
      }
      var range = p to max by p
      primes = primes :+ p
      intersect = (intersect ++ range).distinct
    }
    
    var firstHalf = 2D to max/2 by 1D
    var otherPrimes = firstHalf.diff(intersect)
    
     
    primes.union(otherPrimes).distinct.sorted
  }
  
  
  def isPrime(x:Double, list:List[Double]) : Boolean = {
    ! list.exists {  n => help.modN(n)(x) }
  }
  
}
