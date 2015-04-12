package kaggle

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object BikesApp {

  val TRAIN_FILE = "data/train.csv"
  val TEST_FILE = "data/test.csv"
  val OUT_FILE = "out/predictions.csv"


  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Bikes")
    val sc = new SparkContext(conf)
    val train = loadTrainData(sc, TRAIN_FILE)
    buildModel(sc, train)
    val test = loadTrainData(sc, TEST_FILE)
   }

  def loadTrainData(sc: SparkContext, fileName: String): RDD[String] = {
    sc.textFile(fileName)
  }

  def buildModel(sc: SparkContext, rdd: RDD[String]): Unit = {
    println(rdd.count())
  }
 }