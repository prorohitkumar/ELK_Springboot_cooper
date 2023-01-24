FROM openjdk:11
EXPOSE 8888
ADD ./target/config-server-0.0.1-SNAPSHOT.jar /usr/src/config-server-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "config-server-0.0.1-SNAPSHOT.jar"]
