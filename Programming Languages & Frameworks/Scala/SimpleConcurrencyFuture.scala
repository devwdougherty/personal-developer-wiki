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

    val futureFailureAndSuccess = Future { 

        sleep(Random.nextInt(500))
        if (Random.nextInt(500) > 250) throw new Exception("Yikes!")
    }

    /* Seems that onSuccess and onFailure methos are both deprecated in Scala 2.12 and removed in Scala 2.13
       We need to use onComplete instead. */
    /*futureFailureAndSuccess.onSuccess {

        case result => println(s"Success: $result")
    }

    futureFailureAndSuccess.onFailure {

        case t => println(s"Exception: ${t.getMessage}")
    }*/

    // do whatever you want - your work
    println("D ..."); sleep(100)
    println("E ..."); sleep(100)
    println("V..."); sleep(100)
    println("W ..."); sleep(100)
    println("D ..."); sleep(100)
    sleep(2000)

    def longRunningComputation(i: Int): Future[Int] = {

        sleep(100)
        Future(i + 1) // We could return a Future basic type that has inside: Success or Failure.
    }

    // No Bloking - Using future callback methods
    longRunningComputation(11).onComplete {

        case Success(result) => println(s"result = $result")
        case Failure(e) => e.printStackTrace
    }

    // keeping the JVM from shutting down.
    sleep(2000)

    // do whatever you want - your work
    println("F ..."); sleep(100)
    println("S ..."); sleep(100)
    println("S ..."); sleep(100)
    println("P ..."); sleep(100)
    println("X ..."); sleep(100)
    sleep(1000)

    def sleep(time: Long) { Thread.sleep(time) }
}

