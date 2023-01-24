#FROM openjdk:11
#EXPOSE 8085
#ADD ./target/cooperai-0.0.1-SNAPSHOT.jar /usr/src/cooperai-0.0.1-SNAPSHOT.jar
#WORKDIR usr/src
#ENTRYPOINT ["java","-jar", "cooperai-0.0.1-SNAPSHOT.jar"]


FROM openjdk:11-jre-slim as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ./
RUN java -Djarmode=layertools -jar cooperai-0.0.1-SNAPSHOT.jar extract

FROM openjdk:11-jre-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]