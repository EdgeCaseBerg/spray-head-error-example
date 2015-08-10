organization := "example"

name := "spray-head"

version := "0.0.0-SNAPSHOT" 

scalaVersion := "2.11.5"

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _)

libraryDependencies ++= { 
	val sprayV = "1.3.3" 
	val akkaV = "2.3.9"
	Seq(
		"io.spray"            %%  "spray-can"     % sprayV,
		"io.spray"            %%  "spray-routing" % sprayV,
		"io.spray"            %%  "spray-json"    % "1.3.1",
		"com.typesafe.akka"   %%  "akka-actor"    % akkaV,
		"com.typesafe" % "config" % "1.2.1",
		"com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
		"com.typesafe.akka"   %%  "akka-slf4j"  % akkaV,
		"org.slf4j" % "slf4j-api" % "1.7.7",
		"io.spray"            %%  "spray-testkit" % sprayV  % "test",
		"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
	)
}

fork in Test := true // allow to apply extra setting to Test

javaOptions in Test += "-Dconfig.resource=test.conf" // apply extra setting here