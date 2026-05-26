# Águia Express Inova API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![H2](https://img.shields.io/badge/Database-H2-blue)

RESTful API developed with Java and Spring Boot for logistics and parcel delivery management.

---

# Overview

Águia Express Inova is a backend system focused on the logistics operations of a delivery company.

The platform manages:
- deliveries
- parcels
- warehouses
- operators
- users
- logistics metrics

The system was designed to support:
- delivery drivers
- warehouse operators
- managers
- team leaders

It also includes dashboard metrics for operational monitoring and delivery performance.

---

# Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- H2 Database
- Swagger / OpenAPI
- Maven
- Lombok

---

# Features

## Deliveries Management
- Create deliveries
- Update delivery status
- Delete deliveries
- Search deliveries
- Urgency level control

## Parcel Management
- Register parcels
- Track parcel information
- Manage parcel value and weight

## Warehouse Management
- Register warehouses
- Manage warehouse capacity
- Logistics organization

## Operators Management
- Register operators
- Link operators to deliveries
- Logistics staff management

## User Management
- User registration
- Role-based access:
  - OPERATOR
  - MANAGER
  - LEADER

## Dashboard Metrics
- Reduced delivery time
- Number of parcels delivered on time
- Operational metrics

## Security
- Spring Security authentication
- Protected endpoints
- HTTP Basic Authentication

---

# API Documentation

Swagger UI:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# H2 Database Console

```bash
http://localhost:8080/h2-console
```

## H2 Configuration

### JDBC URL

```bash
jdbc:h2:file:./data/aguiaexpressdb
```

### Username

```bash
sa
```

### Password

```bash

```

---

# Authentication

Default credentials for testing:

## Username

```bash
admin
```

## Password

```bash
123456
```

---

# Main Endpoints

## Users

```http
GET /usuarios
POST /usuarios
PUT /usuarios/{id}
DELETE /usuarios/{id}
```

---

## Deliveries

```http
GET /entregas
POST /entregas
PUT /entregas/{id}
DELETE /entregas/{id}
```

---

## Operators

```http
GET /operadores
POST /operadores
PUT /operadores/{id}
DELETE /operadores/{id}
```

---

## Warehouses

```http
GET /armazens
POST /armazens
PUT /armazens/{id}
DELETE /armazens/{id}
```

---

## Parcels

```http
GET /encomendas
POST /encomendas
PUT /encomendas/{id}
DELETE /encomendas/{id}
```

---

## Dashboard

```http
GET /dashboard/metricas
```

---

# Project Structure

```text
src
 ┣ controller
 ┣ service
 ┣ repository
 ┣ dto
 ┣ model
 ┣ config
 ┗ enums
```

---

# Running the Project

## Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/aguia-express-api.git
```

---

## Open the project

Open the project using IntelliJ IDEA.

---

## Run the application

Run the main Spring Boot application.

---

# Future Improvements

- JWT Authentication
- MySQL/PostgreSQL support
- Docker deployment
- Mobile app integration
- Cloud deployment
- Real-time tracking

---

# Team

Developed by Gustavo Storion
