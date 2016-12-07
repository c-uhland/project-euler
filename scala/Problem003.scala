
/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 */
object Problem003 {
  var help = new Function()
  var number = 600851475143L
  var primes = new SieveOfEratosthenes(number).buildPrimes()
  
  
  
  def main(args: Array[String]): Unit = {
    var result = findLargestPrime(number)
    
    println(result)
  }
  
  def findLargestPrime(x: Double) : Double = {
    var y = primes.head
    flpr(x, y, List())
  }
  
  def flpr(x: Double, prime:Double, factorList:List[Double]) : Double = {
    if (x == 1){
      factorList.last
    }
    else if (help.modN(prime)(x)){
      var t = factorList :+ prime
      flpr(x/prime, prime, t)
      
    } else {
      var nextPrime = getNextPrime(prime)
      flpr(x, nextPrime, factorList)
    }
  }
  
  def getNextPrime(cur:Double) : Double = {
    var filterList = primes.filter { x => x > cur }
    filterList.reverse.last
  }
  
  def isPrime(x:Double) : Boolean = {
    ! primes.exists {  n => help.modN(n)(x) }
  }
}
