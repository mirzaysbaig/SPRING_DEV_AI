# Learning Notes

## 1. Spring Boot Microservices

### 1.1 Eureka Service Registry

* Created **Eureka Server** (`@EnableEurekaServer`)
* Dashboard started: `http://localhost:8761`

### 1.2 Microservices Registration

* **Product Service**

  * Endpoint: `GET /api/product`
  * Response: `This is product API`
* **Order Service**

  * Endpoints: `GET /health`, `GET /order`
* Both services successfully registered in **Eureka Dashboard**.

### 1.3 Inter-Service Communication

* **Order Service → Product Service** using Eureka service name
* Call used: `http://product-service/api/product`
* Implemented using `RestTemplate + @LoadBalanced`

Flow: `Client → Order Service → Eureka → Product Service`

### 1.4 API Gateway

Implemented **Spring Cloud Gateway** for routing requests.

* **GatewayConfig (Java Config)**

  * `/order/** → order-service`
* **application.yml**

  * `/product/** → product-service`

Flow: `Client → API Gateway → Eureka → Services`

---


