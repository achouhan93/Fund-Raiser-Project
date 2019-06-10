FROM openjdk:8
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT [“java”, “-jar”, “fundraiser.jar”]


# Build the image by command to make it availabel in local Docker registry:
# docker build -t server .
# docker run -p 8080:8080 server

