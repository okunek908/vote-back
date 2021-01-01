# There are 2 ways to build docker image: (1) Use Maven jib-maven-plugin and (2) Use this Dockerfile
# Both results in correct layering to optimise build time and storage size.
FROM maven:3-openjdk-15-slim as builder
WORKDIR /usr/build
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn package

FROM openjdk:15-slim as runner
COPY --from=builder /usr/build/target/dependency-jars /app/dependency-jars
COPY --from=builder  /usr/build/target/vote-backend-1.0-SNAPSHOT.jar /app/vote-back.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "/app/vote-back.jar"]


