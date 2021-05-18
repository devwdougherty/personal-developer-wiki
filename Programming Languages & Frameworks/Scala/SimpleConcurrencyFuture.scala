import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.util.Random

object FuturesDevWDougherty extends App {

    implicit val baseTime = System.currentTimeMillis

    // Creating the future
    val f = Future {

        sleep(500)
        1 + 1
    }

    // Using Blocking - Bad Way
    val result = Await.result(f, 1 second)
    println(result)
    sleep(1000)

    // Using Callback - Better Approach
    println("starting calculation...")
    
    val w = Future {
        
        sleep(Random.nextInt(500))
        42
    }
    
    println("before OnComplete")
    w.onComplete { 
        
        case Success(value) => println(s"Got the callback, meaning = $value")
        case Failure(e) => e.printStackTrace
    }

    // do whatever you want - your work
    println("W ..."); sleep(100)
    println("I ..."); sleep(100)
    println("L ..."); sleep(100)
    println("L ..."); sleep(100)
    println("I ..."); sleep(100)
    println("A ..."); sleep(100)
    println("N ..."); sleep(100)
    sleep(2000)

    def sleep(time: Long) { Thread.sleep(time) }
}

