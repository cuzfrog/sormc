[![wercker status](https://app.wercker.com/status/ecf1f72ff3e08c445b3667c3a06f3129/s/master "wercker status")](https://app.wercker.com/project/bykey/ecf1f72ff3e08c445b3667c3a06f3129)
[ ![Download](https://api.bintray.com/packages/cuzfrog/maven/sormc/images/download.svg) ](https://bintray.com/cuzfrog/maven/sormc/_latestVersion)

#SORMC

This is my altered version of [Sorm](http://sorm-framework.org/).

###Change:

1. Use sbt instead of Maven to build. Speed up resolution by fixing scala version to 2.11.8 and 2.12.1 .
2. Included original author's sub dependent libraries.
3. Migrated from joda time to java8 time.
4. Update scala-logging to 3.5.0.

###Use:

Originally based on Sorm 0.3.20.

Resolver:

    resolvers += "bintray-cuzfrog-maven" at "http://dl.bintray.com/cuzfrog/maven"


Artifact:

    libraryDependencies += "com.github.cuzfrog" %% "sormc" % "1.1.0"


