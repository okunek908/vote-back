# There are 2 ways to build docker image: (1) Use Maven jib-maven-plugin and (2) Use this Dockerfile
# Both results in correct layering to optimise build time and storage size.
# This Docker file assumes that Maven has already been run rathter than cretate a multistage build.
# Reasoning - to leverage CI/CD maven agent cache. If I build in this docker image, maven will start with empty m2 folder.
# (Though it is possible to mount cache folder, I opted to have 2 stages in CI/CD rather than in the Dockerfile)

FROM openjdk:15-slim
COPY target/dependency-jars /run/dependency-jars
ADD target/vote-backend-1.0-SNAPSHOT.jar /run/vote-back.jar

ENTRYPOINT java -jar run/vote-back.jar



