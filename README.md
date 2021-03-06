# Example Quarkus Project

<a href="https://github.com/eis/quarkus-example/actions/workflows/github-actions-build.yml" title="Build Status">
  <img src="https://github.com/eis/quarkus-example/actions/workflows/github-actions-build.yml/badge.svg">
</a>
<a href="https://codecov.io/gh/eis/quarkus-example" title="Coverage Status">
  <img src="https://codecov.io/gh/eis/quarkus-example/branch/master/graph/badge.svg?token=QhUicfrjBn">
</a>


This project uses [Quarkus](https://quarkus.io/).

Features
 - JAX-RS rest api
 - Qute html templates
 - Unit, integration tests
 - Github Actions build
 - CodeCov integration

Answers to http://localhost:8080/ (GET).

Requirements coming from Quarkus are
 - JDK 11+ (any distribution)
 - Optionally GraalVM 21.1.0 for native compilation
 - Apache Maven 3.8.1+
 
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
mvn package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
mvn package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
mvn package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more
- Qute ([guide](https://quarkus.io/guides/qute)): Template engine for HTML
