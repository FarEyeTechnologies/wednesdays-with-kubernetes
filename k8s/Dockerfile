# Use a base image with JDK and Maven installed
FROM maven:3.9-amazoncorretto-21-al2023 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download and cache dependencies
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new image from amazoncorretto
FROM amazoncorretto:21-al2023-headless

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run the application when the container starts
ENTRYPOINT ["java","-jar","app.jar"]
