FROM openjdk:8
ADD target/fundraiser.jar fundraiser.jar
EXPOSE 8085
ENTRYPOINT [“java”, “-jar”, “fundraiser.jar”]

# Pull the postgres docker file *** postgres:10-alpine***
# Build the image by command to make it availabel in local Docker registry:
# docker build -t server .
# docker run -p 8080:8080 server

