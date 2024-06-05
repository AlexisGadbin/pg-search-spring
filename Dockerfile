# Stage 1: Build the application
FROM maven as build

WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests


# Stage 2: Run the application
FROM openjdk:21-jdk

RUN mkdir -p /app
WORKDIR /app
COPY --from=build /app/target/search-0.0.1-SNAPSHOT.jar /app/spring.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring.jar"]
