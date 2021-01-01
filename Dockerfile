# There are 2 ways to build docker image:
# (1) Use Maven jib-maven-plugin goal jib:dockerBuild and
# (2) Use this Dockerfile
# Both results in correct layering to optimise build time and storage size.
# NOTE: the docker build should be run after 'mvn package' as it expects ./target folder with jars.

FROM openjdk:15-slim
COPY target/dependency-jars /app/dependency-jars
COPY target/vote-backend-1.0-SNAPSHOT.jar /app/vote-back.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "/app/vote-back.jar"]



