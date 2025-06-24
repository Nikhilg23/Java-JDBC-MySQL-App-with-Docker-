# Java JDBC MySQL App (with Docker)

This is a simple Java application that connects to a MySQL database using JDBC and performs basic operations like insert, update, delete, and Fetch. The app is packaged in a Docker container for easy deployment.

## 🔧 Technologies Used
- Java
- JDBC
- MySQL
- Docker

## 📁 Files
- App.java – your main Java file
- mysql-connector-j-9.3.0.jar – MySQL driver
- Dockerfile – used to build Docker image

## 🚀 How to Run

### 1. Build Docker image
```bash
docker build -t java-jdbc-app .
```

### 2. Pull MySQL image from Docker Hub
```bash
docker pull mysql
````
### 3. Create a Docker network
```bash
docker network create jdbc-network
```
### 4. Start MySQL container on the network
```bash
docker run -d --name mysql --network jdbc-network -e MYSQL_ROOT_PASSWORD=yourPassword -e MYSQL_USERNAME=root -e MYSQL_DATABASE=jdbc_db mysql
```
### 5. Start the Java app container on the same network
```bash
docker run -it --name java-app --network jdbc-network -e MYSQL_ROOT_PASSWORD=yourPassword -e MYSQL_DATABASE=jdbc_db java-jdbc-app
```
## ✅ Done

## ✅ JDBC Connection Example in App.java

 String url = "jdbc:mysql://mysql:3306/jdbc_db"; \
 String username = "root"; \
 String password = System.getenv("MYSQL_ROOT_PASSWORD"); \
 Connection con = DriverManager.getConnection(url, username, password);

## 📌 Additional
 
⚠️ Before running the Java app, make sure the database and table exist.
If not, you'll get an error like "table not found".

🗃️ Step 1: Create Database (optional if not using "MYSQL_DATABASE" env var)
```mysql
CREATE DATABASE jdbc_db;
```
🗂️ Step 2: Create Table
```mysql
USE jdbc_db;
```
```mysql
CREATE TABLE jdbc_table (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  channel VARCHAR(255)
);
```

✅ Done \
You're now ready to use your Java JDBC + MySQL app with Docker. 🎉


