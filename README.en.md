

# Spring Cloud Demo Project

This is a microservice example project based on Spring Cloud, containing multiple service modules, suitable for learning and demonstrating the fundamental concepts and implementation methods of microservice architecture.

## Project Structure

- **gateway**: Gateway service, used to route requests to various microservices.
- **services**: Directory containing business service modules.
  - **service-order**: Order service, providing order-related functionality.
  - **service-product**: Product service, providing product-related functionality.

## Technology Stack

- Spring Boot
- Spring Cloud Gateway
- Microservice architecture

## Quick Start

### Environment Requirements

- Java 8 or higher
- Maven
- Git

### Startup Steps

1. Clone the repository:

   ```bash
   git clone https://gitee.com/knowwen/spring-cloud-demo
   cd spring-cloud-demo
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Start the services:

   - Start the gateway service:
     ```bash
     java -jar gateway/target/*.jar
     ```

   - Start the order service:
     ```bash
     java -jar services/service-order/target/*.jar
     ```

   - Start the product service:
     ```bash
     java -jar services/service-product/target/*.jar
     ```

4. Access the services:
   - Order service: Visit `http://localhost:8080/order` to view the order service homepage.
   - Product service: Visit `http://localhost:8080/product` to view the product service homepage.

## Service Overview

### Gateway Service (gateway)

The gateway service serves as the entry point of the entire system, responsible for routing requests to the corresponding microservice modules.

### Order Service (service-order)

The order service demonstrates a simple REST interface; accessing the root path `/` will return a welcome message.

### Product Service (service-product)

The product service also provides a REST interface; accessing the root path `/` will return a welcome message.

## Contribution Guide

Contributions of code and improvements are welcome! Please follow these steps to submit a Pull Request:

1. Fork this repository.
2. Create a new branch.
3. Commit your code changes.
4. Create a Pull Request.

## License

This project is licensed under the MIT License. Please see the LICENSE file in the repository for more details.