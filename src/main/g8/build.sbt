name := "scalatutorial"

ThisBuild / scalaVersion := "2.13.16"
ThisBuild / scalacOptions ++= Seq("-feature", "-deprecation", "-Xlint:unused")

lazy val macros = (project in file("macros")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % Test,

  wartremoverClasspaths += "file://" + baseDirectory.value + "/../lib/cs320warts.jar",
  wartremoverErrors ++= Seq(
    Wart.AsInstanceOf, Wart.IsInstanceOf, Wart.Null, Wart.Return, Wart.Throw, Wart.Var, Wart.While,
    Wart.custom("cs320warts.MutableDataStructures"), Wart.custom("cs320warts.TryCatch")
  ),
  wartremoverExcluded += baseDirectory.value / "src" / "main" / "scala" / "package.scala"
).dependsOn(macros)

run := (core / Compile / run).evaluated
test := (core / Test / test).value
