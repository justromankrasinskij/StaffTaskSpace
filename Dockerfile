FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/
CMD ["java", "-jar", "/opt/app/*.jar"]
