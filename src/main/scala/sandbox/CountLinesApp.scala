package sandbox

import org.apache.spark.{SparkConf, SparkContext}

object CountLinesApp {

  val DATA_FILE = "data/README.md"

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Line Count Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(DATA_FILE, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}