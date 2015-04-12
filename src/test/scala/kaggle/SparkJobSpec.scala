package kaggle

import org.apache.spark.{SparkConf, SparkContext}
import org.specs2.Specification


abstract class SparkJobSpec extends Specification {

  @transient var sc: SparkContext = _

  def beforeAll = {
    System.clearProperty("spark.driver.port")
    System.clearProperty("spark.hostPort")

    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("test")
    sc = new SparkContext(conf)
  }

  def afterAll = {
    if (sc != null) {
      sc.stop()
      sc = null
      System.clearProperty("spark.driver.port")
      System.clearProperty("spark.hostPort")
    }
  }

}