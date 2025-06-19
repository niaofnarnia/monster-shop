# 🛒 Monster Shop - Backend API

This is the backend REST API for the **Monster Shop** e-commerce application, built with **Java 21**, **Spring Boot**, and **MySQL**. It allows clients to manage products and reviews, and connects with a provided frontend built with Vite and React.

---

## 📦 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate Validator
- Maven
- CORS Configuration for Frontend (Vite @ port 5173)

---

## 🚀 How to Run the Project

### ✅ Prerequisites

Make sure you have the following installed:

- Java 21+
- Maven
- MySQL
- IDE like IntelliJ (recommended)
- Postman (for testing)
- Git (to clone the repository)

---

### 🛠️ Setup Steps

1. **Clone the Backend Repository**

    git clone https://github.com/niaofnarnia/monster-shop.git

   cd monster-shop


2.**Create the Database in MySQL:**

    CREATE DATABASE monster_shop;

💡 Make sure your application.properties file (or application.yml) contains the correct DB connection info (username, password, port).

3. **Configure Database Access**

In src/main/resources/application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/monster_shop
    spring.datasource.username=YOUR_USERNAME
    spring.datasource.password=YOUR_PASSWORD

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

4. **Build the Project**

From the root directory:

    ./mvnw clean install

5. **Run the App**


    ./mvnw spring-boot:run

The backend will run at:
📍 http://localhost:8080

🌐 API Endpoints

📦 Product Endpoints

Method - Endpoint -----------Description

GET -----/api/products ------Get all products

GET ----/api/products/{id} --Get a specific product by ID

POST---/api/products--------Create a new product

PUT-----/api/products/{id}---Update an existing product

DELETE--/api/products/{id} ---Delete a product

✍️ Review Endpoints

Method------Endpoint----------------------Description

GET------	/api/reviews/{productId}-----Get all reviews for a product

POST----/api/reviews/{productId}------Create a new review for a product

🔗 Connecting to the Frontend
The provided frontend runs at:
📍 http://localhost:5173

✅ Enable CORS in Backend

In src/main/java/com/FemCoders/monster_shop/config/CorsConfig.java:

    @Configuration
    public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

🧪 Testing
You can use Postman to test all endpoints locally before connecting the frontend.

👩‍💻 Author
Developed by [niaofnarnia](https://github.com/niaofnarnia)