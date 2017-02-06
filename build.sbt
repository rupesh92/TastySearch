name := """tastysearch"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

//libraryDependencies ++= Seq(
//  cache,
//  javaWs
//)
//
//libraryDependencies ++= Seq(
//  javaJpa,
//  "org.mockito" % "mockito-core" % "2.1.0",
//  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final" // replace by your jpa implementation
//)

scalaVersion := "2.11.8"

libraryDependencies += javaJpa

libraryDependencies += "org.mockito" % "mockito-core" % "2.1.0"

libraryDependencies += javaWs % "test"

//libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.5.Final"
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final"

