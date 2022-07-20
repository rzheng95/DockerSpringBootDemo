#FROM eclipse-temurin:11
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

# Arguments are passed from build.gradle
ARG JDK_VERSION
ARG WORK_DIR
ARG JAR_FILE

FROM eclipse-temurin:${JDK_VERSION} as BUILD
# ARGs only last for the build phase of a single image. For the multistage, renew the ARG by simply stating:
ARG WORK_DIR

# Copy Gradle wrapper files to WORK_DIR
# copy the entire gradle folder
# copy the entire WORK_DIR folder
COPY *.gradle gradle.* gradlew /${WORK_DIR}/
COPY gradle /${WORK_DIR}/gradle
COPY src /${WORK_DIR}/src

# set up the working directory
WORKDIR /${WORK_DIR}

# run a task to invoke downloading gradle wrapper from the internet
RUN ./gradlew --version
# generate jar file in build/libs/
RUN ./gradlew --no-daemon assemble


# We don't need all the source files used to generating the Jar file to be included in the image
# simply copy the generated Jar file from build stage to current stage
FROM eclipse-temurin:${JDK_VERSION}
ARG WORK_DIR
ARG JAR_FILE
# copy jar file from build stage to current stage
COPY --from=BUILD /${WORK_DIR}/build/libs/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]