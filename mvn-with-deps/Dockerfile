# Supplementary Dockerfile that builds image of maven with pre-cached dependencies
# with the goal to make mvn builds (that uses this intermediary image) faster
FROM gcr.io/cloud-builders/mvn
WORKDIR /tmp
COPY pom.xml .
RUN ["mvn", "-B", "clean", "dependency:go-offline"]