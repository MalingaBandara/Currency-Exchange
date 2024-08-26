
# Currency Exchange Microservice

This repository contains the source code for the Currency Exchange Microservice of the Currency Conversion and Exchange API project. 

## Project Overview

This repository contains the Currency Exchange Microservice, which is a key component of the Currency Conversion and Exchange API project. The microservice handles currency exchange operations, offering conversion based on predefined exchange rates. It integrates seamlessly with other microservices in the architecture, enabling a distributed and scalable solution.

## Key Features

- Currency exchange operations based on stored exchange rates.
- Integration with Eureka for service discovery.
- H2 database setup for storing and retrieving exchange rate data.
- Dockerized for seamless deployment in containerized environments.

## Technologies Used

- **Java**
- **Spring Boot**
- **H2 Database**
- **Eureka Server**
- **Docker**

## Project Structure and Code Explanation

1. **Exchange Rate Logic**:
   - Implements currency conversion logic using exchange rates stored in the H2 database.
   - REST endpoints are exposed for querying exchange rates based on currency pairs.
   ```java
   @GetMapping("/currency-exchange/from/{from}/to/{to}")
   public CurrencyExchange retrieveExchangeValue(
       @PathVariable String from,
       @PathVariable String to) {
       // Logic to retrieve exchange rate
   }
   ```

2. **Service Registration with Eureka**:
   - The microservice registers with Eureka for dynamic service discovery, allowing other microservices to locate it easily.
   ```yaml
   eureka:
     client:
       service-url:
         defaultZone: http://localhost:8761/eureka/
   ```

3. **H2 Database Configuration**:
   - The microservice uses an H2 in-memory database for managing exchange rates, pre-populated with initial data.

4. **Docker Setup**:
   - The microservice is fully containerized using Docker for easy deployment and scaling.

## Commits and Project Evolution

1. **Initial Setup**: Created the project structure and implemented exchange rate logic.
2. **Service Discovery Integration**: Added Eureka client configuration for dynamic registration.
3. **Containerization**: Integrated Docker for deploying the microservice.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/Currency-Exchange.git
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Run the service:
   ```bash
   mvn spring-boot:run
   ```
4. Alternatively, use Docker:
   ```bash
   docker-compose up
   ```

## Purpose and Future Enhancements

This microservice demonstrates my ability to build scalable and modular components in a distributed system. Future enhancements could include adding real-time currency rate fetching, integrating caching mechanisms, and improving fault tolerance with circuit breakers.

## Main Repository

- [Currency Conversion and Exchange API](https://github.com/MalingaBandara/Currency-Conversion-Exchange-Microservices)

## What's Covered in This Microservice

- Implementation of currency exchange logic.
- Integration with the Naming Server Microservice for service discovery.
- Utilization of Docker for containerization and deployment.
- Population of H2 database with exchange rates data.

## License

This project is licensed under the MIT License.
