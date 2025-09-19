<!-- PROJECT LOGO -->
<div align="center">

# 🛒 E-Commerce Management System
✨ *A Robust Backend System built with Core Java & DBMS* ✨

A powerful, console-based application designed to streamline retail operations by providing a complete digital solution for managing users, products, and inventory.

</div>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img alt="MySQL" src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge">
</p>

---

## ✨ Overview
Welcome to the **E-Commerce Management System**!

This project was developed to solve the challenges of managing a large-scale retail store. It provides a user-friendly, **command-line interface** for both administrators (owners) and customers to interact with the store's data efficiently.

Built entirely in **Core Java**, this system demonstrates strong object-oriented principles, robust database management, and clean application logic.

---

## 📋 Table of Contents
- [🌟 Features](#-features)
- [🛠️ Technology Stack](#️-technology-stack)
- [🚀 Getting Started](#-getting-started)
  - [✅ Prerequisites](#-prerequisites)
  - [⚡ Installation & Setup](#-installation--setup)
- [📂 Project Structure](#-project-structure)
- [🔮 Future Scope](#-future-scope)
- [📄 License](#-license)

---

## 🌟 Features
- ✅ **Dual User Roles:** Separate functionalities for administrators and regular users.
- ✅ **Complete Product Management (Admin):** Full CRUD (Create, Read, Update, Delete) capabilities for all products.
- ✅ **User & Order Management:** Admins can view user data and manage orders.
- ✅ **Dynamic Product Filtering:** Users can view products sorted by price (high-to-low or low-to-high).
- ✅ **Secure User Authentication:** Secure login and registration system for all users.
- ✅ **Integrated Shopping Cart:** Users can add products to a cart and view them before purchase.

---

## 🛠️ Technology Stack
- **Java:**
  - **Core Java:** The entire application logic is built using strong Object-Oriented Programming (OOP) principles.
  - **JDBC (Java Database Connectivity):** Connects the application to the MySQL database for all data operations.
  - **Collections Framework:** Utilizes `ArrayList`, `HashSet`, and `Comparator` for efficient data handling and sorting.
  - **IO Programming:** Implemented file I/O to allow admins to download product lists as `.txt` files.
  - **Exception Handling:** Robust error management for potential SQL and user input errors.
- **MySQL (DBMS):**
  - Used as the relational database to store and manage all user, product, and category data, ensuring data integrity.

---

## 🚀 Getting Started
This is a backend-only project that runs in the console.

### ✅ Prerequisites
- Java Development Kit (JDK) 8 or higher.
- MySQL Server installed and running.
- An IDE like IntelliJ IDEA or Eclipse is recommended.

### ⚡ Installation & Setup
1.  **Clone the repository:**
    ```bash
    git clone https://github.com/patelarpit21/e-commerce-system.git
    ```

2.  **Navigate to the project folder:**
    ```bash
    cd e-commerce-system
    ```

3.  **Database Setup:**
    - Open your MySQL client (e.g., MySQL Workbench, Command Line).
    - Create and use a new database named `ecommerce`:
      ```sql
      CREATE DATABASE ecommerce;
      USE ecommerce;
      ```
    - Run the following SQL scripts to create the necessary tables:
      ```sql
      -- Create the 'user' table
      CREATE TABLE user (
          id INT AUTO_INCREMENT PRIMARY KEY,
          uname VARCHAR(255) NOT NULL UNIQUE,
          password VARCHAR(255) NOT NULL,
          email VARCHAR(255) NOT NULL UNIQUE
      );

      -- Create the 'products' table
      CREATE TABLE products (
          pid INT AUTO_INCREMENT PRIMARY KEY,
          name VARCHAR(255) NOT NULL,
          price DOUBLE NOT NULL,
          stock INT NOT NULL,
          cid INT
      );

      -- Insert a default owner for testing
      INSERT INTO user (uname, password, email) VALUES ('owner', 'owner123', 'owner@example.com');
      ```

4.  **Configure Database Connection:**
    - Open the file: `DatabaseConnection/dbc.java`.
    - Update the `URL`, `USER`, and `PASSWORD` fields to match your MySQL setup if they are different.

5.  **Compile and Run:**
    - Open the project in your IDE.
    - Compile all the Java files.
    - Run the `Main.java` file to start the application in your console.

---

## 📂 Project Structure
```bash
e-commerce-system/  
│
├── Categorypack/
│ └── Category.java # Handles product categories
│
├── DatabaseConnection/
│ └── dbc.java # Manages the JDBC connection
│
├── E_commercesystem/
│ └── methods.java # Contains core methods for owner & user
│
├── Order/
│ └── order1.java # Class for handling orders
│
├── product/
│ └── product.java # Product class with CRUD methods
│
├── user/
│ └── user1.java # User class with auth methods
│
└── Main.java # Main entry point of the application
```
---

## 🔮 Future Scope
📌 **Web-Based UI:** Develop a full-stack web application with a modern front-end framework (like React or Angular).  
📌 **Multi-User Connectivity:** Enhance the system to support simultaneous access for multiple users over the internet.  
📌 **Advanced Order System:** Implement a complete order tracking and history feature for users.  
📌 **More Filtering Options:** Add advanced search and filtering by category, brand, and other attributes.  

---

## 📄 License
This project is licensed under the **MIT License**. You are free to use, modify, and distribute this project.

<br>

<div align="center">
  
💡 *Built to demonstrate solid backend principles.*  
*Efficient. Scalable. Robust.* 🎉  

</div>
