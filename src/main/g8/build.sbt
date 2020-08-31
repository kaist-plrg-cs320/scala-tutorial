ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "cs320"
ThisBuild / name := "scalatutorial"
ThisBuild / version := "1.0.0"

ThisBuild / scalacOptions += "-feature"
ThisBuild / scalacOptions += "-deprecation"
ThisBuild / scalacOptions += "-Xlint:unused"

run := (core / Compile / run).evaluated
test := (core / Test / test).value

lazy val macros = (project in file("macros")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % Test
) dependsOn macros
