# Stage 1: Build using Maven with JDK 17
FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app
RUN mvn clean package

# Stage 2: Deploy WAR in Tomcat
FROM tomcat:10

COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/
