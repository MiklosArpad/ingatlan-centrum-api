# ingatlan-centrum-api

IngatlanCentrum real-estate management system's api.

[![Build](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml/badge.svg)](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml)

## Running project locally

### Prerequisites

To avoid any unexpected behaviour make sure you have installed the following tools:

- [Maven 3.8.5](https://maven.apache.org/download.cgi)
- [OpenJDK 11](https://adoptium.net/temurin/releases)

1. Before start, make sure you run:

```bash
mvn clean install -Dspring.profiles.active=dev
```

2. Run with Spring Boot Maven plugin:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

or

3. Run the packaged application:

```bash
mvn clean package

java -jar -Dspring.profiles.active=dev target/ingatlan-centrum-api-0.0.1-SNAPSHOT.jar
```

4. For SwaggerUI open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to view it in the browser.
