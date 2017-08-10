name := "cats"

version := "1.0"

scalaVersion := "2.12.3"

resolvers ++= Seq(
  "Twitter"                       at "http://maven.twttr.com",
  "Maven Central Server"          at "http://repo1.maven.org/maven2",
  "TypeSafe Repository Releases"  at "http://repo.typesafe.com/typesafe/releases",
  "TypeSafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots",
  "Sonatype"                      at "https://oss.sonatype.org/content/groups/public"
)

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-macros" % "1.0.0-MF",
  "org.typelevel" %% "cats-kernel" % "1.0.0-MF",
  "org.typelevel" %% "cats-core"   % "1.0.0-MF"
)
