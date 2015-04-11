import org.apache.spark.{SparkConf, SparkContext}

object CountWordsApp {

  val DATA_FILE = "/home/klangner/bin/spark-1.3.0-bin-hadoop2.4/README.md"

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(DATA_FILE, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}