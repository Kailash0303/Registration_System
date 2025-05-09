# Registration System (Hibernate + Servlets + MVC)

A full-stack Java web application for user registration, authentication, and password management using **Hibernate ORM**, **Servlets**, and a clean layered architecture (Controller-Service-DAO). The system securely stores user passwords using **MD5 encryption**, verifies emails, prevents duplicate registrations, and allows password changes.



## ✅ Features

- 🔐 Secure password storage with **MD5 encryption**
- 📧 Email verification & uniqueness validation
- 🔁 Password reset/change functionality
- 🗃️ Data persistence with **Hibernate ORM** and **MySQL**
- 🧑‍💻 MVC-based structure (Servlet Controller, Service, DAO, Model)
- ✉️ Proper form validation and error handling



## 🧱 Architecture Overview

```text
Controller (Servlets)
   ↓
Service Layer
   ↓
DAO (Data Access Objects using Hibernate)
   ↓
MySQL Database
```

Model: JavaBeans/Entities mapped via Hibernate.

DAO: Handles all database operations.

Service: Business logic like hashing, validation.

Controller: Handles HTTP requests and forwards to JSP.


## 🛠 Tech Stack
Java (Servlets, JSP)

Hibernate ORM

MySQL

Apache Tomcat

HTML/CSS

MD5 Hashing (for password encryption)
