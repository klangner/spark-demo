name := "demo"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.3.0"

// Specs2 tests
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.4" % "test")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")