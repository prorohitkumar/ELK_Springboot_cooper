#FROM openjdk:11
#EXPOSE 4200
#ADD ./target/webapp-0.0.1-SNAPSHOT.jar /usr/src/webapp-0.0.1-SNAPSHOT.jar
#WORKDIR usr/src
#ENTRYPOINT ["java","-jar", "webapp-0.0.1-SNAPSHOT.jar"]


FROM openjdk:11-jre-slim as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ./
RUN java -Djarmode=layertools -jar webapp-0.0.1-SNAPSHOT.jar extract

FROM openjdk:11-jre-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]