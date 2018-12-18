# AdventureBox - UAA Service

This is a "microservice" application intended to be part of the AdventureBox system.

This application is configured for Service Discovery and Configuration with . On launch, it will refuse to start if it is not able to connect to .

## Prerequisites

Before you can build and run this project, you must install and configure the following applications on your machine:

 * Install Java 8 from the [Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
 * Install Maven [Oficial website](https://maven.apache.org/).
 * Install [Git](git-scm.com). We recommend you also use a tool like [SourceTree](https://www.sourcetreeapp.com/) if you are starting with Git.

## Development

To start your application in the dev profile, simply run:

```
 $ ./mvnw
```

(this will run our default Maven task, spring-boot:run)

The application will be available on http://localhost:8080.

## Building for production

To optimize the adventures application for production, run:

```
 $ ./mvnw -Pprod clean package
```

## Project profiles

The application comes with two profiles:

 * ```dev``` __for development:__ it focuses on ease of development and productivity.
 * ```prod``` __for production:__ it focuses on performance and scalability.

Those profiles come in two different configurations:

 * The Maven profiles are used at build time. For example ```./mvnw -Pprod package``` will package a production application.
 * The [Spring profiles](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html) work at run time. Some Spring beans will behave differently, depending on the profile.
Spring profiles are set by Maven, so we have a consistency between the two methods: you will have a prod profile on Maven and Spring at the same time.

### Spring profiles switches

The application comes with three additional profiles used as switches:

 * ```swagger``` to enable swagger.
 * ```no-liquibase``` to disable liquibase.
 * ```shell``` to enable the [Spring Boot remote shell](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-remote-shell.html).

These can be used along with both the ```dev``` and ```prod``` profiles. Please note that by default, the ```swagger``` profile is disabled in ```prod``` and enabled in ```dev``` by setting the ```spring.profiles.include``` property in ```application.yml```.

The ```shell``` is only used at build time.

The ```swagger``` and ```no-liquibase``` are only used at runtime:

 * In your IDE, run your main application class with ```spring.profiles.active=dev,no-liquibase``` (please note you need to include the ```dev``` or ```prod``` profile explicitly)
 * With a packaged application: ```./java -jar gfd-0.0.1-SNAPSHOT.war --spring.profiles.active=prod,no-liquibase```

With Maven, you can also use those profiles directly:

 * ```./mvnw -Pprod,swagger,no-liquibase```
 * ```./mvnw -Pdev,no-liquibase,shell```

## Testing

To launch your application's tests, run:

```
 $ ./mvnw clean test
```

UI end-to-end tests are powered by [Protractor][], which is built on top of WebDriverJS. They're located in [src/test/javascript/e2e](src/test/javascript/e2e) and can be run by starting Spring Boot in one terminal (`./mvnw spring-boot:run`) and running the tests (`gulp itest`) in a second one.

### Other tests

Performance tests are run by [Gatling][] and written in Scala. They're located in [src/test/gatling](src/test/gatling) and can be run with:

```
 $ ./mvnw gatling:execute
```