# FROM openjdk:11-jre-slim
# COPY /target/homework17-0.0.1-SNAPSHOT.jar /usr/app/
# WORKDIR /usr/app
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "homework17-0.0.1-SNAPSHOT.jar"]

FROM maven:3.8.6-jdk-11
ENV PROJECT_DIR=/usr/app
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
ADD ./pom.xml $PROJECT_DIR
#RUN mvn -B clean install -DskipTests -Dcheckstyle.skip -Dasciidoctor.skip
RUN mvn dependency:resolve
ADD ./src/ $PROJECT_DIR/src
RUN mvn install
FROM openjdk:11-jre-slim
ENV PROJECT_DIR=/usr/app
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/homework17* $PROJECT_DIR/
EXPOSE 8080
CMD ["java", "-jar", "/usr/app/homework17-0.0.1-SNAPSHOT.jar"]