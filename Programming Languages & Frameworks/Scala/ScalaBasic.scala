import scala.io.Source._

object Test {
    
    def main(args: Array[String]) {

        println("Hello World")
    }

    /* lazy val - its value is evaluated only when the variable is used. Only applies to val and not var (is not considered as a value definition since 
       it can change. */
    object ReadFileExample extends App {

        println(System.getProperty("user.dir"))

        lazy val lines = fromFile(System.getProperty("user.dir") + "/file1.txt").getLines

        println(lines)
    }

    /* Scala Arrays - Array[T] compatible with Seq[T] */
    object myArrays {
        val a1 = Array(1,2,3)
        val a2 = a1.map(_ * 3)
        val a3 = a2.filter(_ % 2 != 0)
        val a4 = a3.reverse

        val seq: collection.Seq[Int] = a1
        val a5: Array[Int] = seq.toArray
        /* a1 eq a4 : Boolean = false */

        /* ArrayOps - Adds all sequence methos to array without turn the array itself into a sequence. */
        val seq: collection.Seq[Int] = a1
        val seqReverse = seq.reverse
        val ops: collection.ArrayOps[Int] = a1
        val opsReverse = ops.reverse
        /* Array[Int] = Array(3,2,1) */
    }
}