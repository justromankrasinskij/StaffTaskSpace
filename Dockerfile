FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /opt/app/
COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./
COPY ./src ./src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/app/
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
CMD ["java", "-jar", "/opt/app/*.jar"]
