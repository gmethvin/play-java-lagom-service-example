
lazy val root = (project in file("."))
  .enablePlugins(PlayService)
  .settings(
    scalaVersion := "2.12.4",
    libraryDependencies ++= Seq(
      lagomJavadslServer,
      akkaHttpServer,
      guice,
      logback
    )
  )
