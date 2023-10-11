# Eazy School Web Application

## Overview
Eazy School is a web application built with Spring Boot, designed to streamline school management processes.

## Prerequisites
- Java Development Kit (JDK) 17
- Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse
- Apache Maven
- Basic knowledge of Java
- Basic knowledge around HTML, CSS

## Getting Started
1. Open the main Spring Boot application class.
2. Run the application, and it will start on port http://localhost:8081/.
3. Access the application in your web browser using the URL: http://localhost:8081/

## Configuring the Database
1. Configure your MySQL database settings in the `application.properties` file.
2. Update the connection URL, username, and password accordingly.

## Features
- Spring Boot
- Thymeleaf
- Spring Security
- Spring Data JPA
- Spring Boot Actuator

## Application Properties
Please configure application-specific properties in the `application.properties` file.

## Profiles
The application uses different profiles, including development and production. Ensure you have the correct profile active for your environment.

## Logging
You can configure logging levels in the `application.properties` file.

## Actuator
The Actuator is used for monitoring your application. Configure Actuator properties in `application.properties`.

## Spring Boot Admin
This project includes Spring Boot Admin, which provides a user-friendly GUI interface for monitoring your Spring Boot Actuator. Make sure to configure it properly for an enhanced monitoring experience.
- [application.properties](https://github.com/Sarthak-sharma1/SpringbootAdmin/blob/main/src/main/resources/application.properties): Configure Spring Boot Admin properties.
- [Main Spring Boot Application Class](https://github.com/Sarthak-sharma1/SpringbootAdmin/blob/main/src/main/java/com/eazybytes/SpringbootAdminApplication.java): The entry point for your Spring Boot Admin application.
- [pom.xml](https://github.com/Sarthak-sharma1/SpringbootAdmin/blob/main/pom.xml): Manage project dependencies and settings.

## Paging and Sorting
This application also incorporates paging and sorting features, making it easy to view and manage messages efficiently.




