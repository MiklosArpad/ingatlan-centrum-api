# ingatlan-centrum-api

IngatlanCentrum real-estate management system's api.

[![Build](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml/badge.svg)](https://github.com/MiklosArpad/ingatlan-centrum-api/actions/workflows/build.yml)

## Running project locally

1. Run with Spring Boot Maven plugin:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

OR

2. Run the packaged application:

```bash
mvn clean package

java -jar -Dspring.profiles.active=dev target/ingatlan-centrum-api-0.0.1-SNAPSHOT.jar
```

Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to view it in the browser.
