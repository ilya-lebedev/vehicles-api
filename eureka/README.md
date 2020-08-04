# Eureka Server

This is a Eureka Server.

## Instructions

Via shell it can be started using

```
$ mvn clean package
```

```
$ java -jar target/eureka-0.0.1-SNAPSHOT.jar
```

The service is available by default on port `8761`.

Eureka dashboard: http://localhost:8761/

You can also import it as a Maven project on your preferred IDE and 
run the class `EurekaApplication`.