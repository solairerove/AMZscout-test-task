# syntax=docker/dockerfile:experimental
FROM maven:3-openjdk-11 as builder
WORKDIR /build

# download dependencies and cache them
COPY pom.xml pom.xml
RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies

# build project
COPY src/main/resources src/main/resources
COPY src/main/kotlin src/main/kotlin

ARG BRANCH_NAME="not-set"
ARG COMMIT_SHA="not-set"
ARG BUILD_TIME="1970-01-01T00:00:00Z"

RUN REVISION=$(mvn help:evaluate) && mvn -DskipTests=true verify --batch-mode --errors --fail-at-end --show-version

# unpack final .jar for layering
RUN mkdir exploded-jar && cd exploded-jar && java -Djarmode=layertools -jar ../target/amzscout-test-task-0.0.1-SNAPSHOT.jar extract

FROM openjdk:11
WORKDIR /application
ENV JAVA_OPTS=""

# copy unpacked layers
COPY --from=builder build/exploded-jar/dependencies/ ./
COPY --from=builder build/exploded-jar/snapshot-dependencies/ ./
COPY --from=builder build/exploded-jar/spring-boot-loader/ ./
COPY --from=builder build/exploded-jar/application/ ./

EXPOSE 8080

# run application
ENTRYPOINT ["sh", "-c", "java -Duser.timezone=UTC $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
