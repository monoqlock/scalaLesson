lazy val root = (project in file(".")).
  settings(
    name := "qiitaF81Project",
    version := "1.0",
    // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor_2.11
    libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.16"
  )