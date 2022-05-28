# ingatlan-centrum-api

IngatlanCentrum real-estate management system's api.

[![Build](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml/badge.svg)](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml)

## Prerequisites

To avoid any unexpected behaviour, make sure you have installed the following tools:

- [Maven 3.8.5](https://maven.apache.org/download.cgi)
- [OpenJDK 11](https://adoptium.net/temurin/releases)

## Running project locally

1. Before start, make sure to provide your local database's credentials in `database-secrets.yml`.

2. To install third-party dependencies, to create database schema and populate it with test data locally, make sure you run:

```bash
mvn clean install -Dspring.profiles.active=dev
```

3. Run with Spring Boot Maven plugin:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

OR

3. Run with packaging:

```bash
mvn clean package

java -jar -Dspring.profiles.active=dev target/<jar-name>.jar
```

4. For SwaggerUI open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to view it in the browser.
