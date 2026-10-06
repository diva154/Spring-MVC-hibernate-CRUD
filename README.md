\# Spring MVC Hibernate CRUD



\## Project Description



This project is a web-based CRUD application developed using Java, Spring MVC, Hibernate, and MySQL.



The application demonstrates how to build a web application using the MVC (Model-View-Controller) architecture and perform database operations using Hibernate/JPA.



\## What is CRUD?



CRUD stands for:



C - Create: Add a new record to the database.



R - Read: Retrieve and display existing records from the database.



U - Update: Modify an existing record.



D - Delete: Remove a record from the database.



For example, if the application manages users, CRUD operations allow us to:



\* Create a new user

\* Read/view users

\* Update user information

\* Delete a user



\## What is MVC?



MVC stands for Model-View-Controller. It is a software design pattern used to separate an application into three main components.



\### Model



The Model represents the application's data and business objects.



In this project, model classes such as User represent the data that is stored in the database.



\### View



The View is responsible for displaying information to the user.



It represents the user interface of the application, where users can view or interact with the data.



\### Controller



The Controller handles requests from the user and controls the flow of the application.



It receives HTTP requests, communicates with the service layer, and returns the appropriate response or view.



\## Application Flow



User

|

v

Controller

|

v

Service

|

v

DAO / Repository

|

v

Hibernate / JPA

|

v

MySQL Database



\## Technologies Used



\* Java - Programming language

\* Spring MVC - Web application framework

\* Hibernate / JPA - Object-relational mapping and database operations

\* MySQL - Relational database

\* Maven - Dependency and project management

\* Apache Tomcat - Application server

\* IntelliJ IDEA - Development environment



\## Database Setup



This project uses MySQL as the database.



Database Name:

db\_demo



Username:

root



Password:

The password is stored only in the local db.properties file and is not committed to Git.



\## Create the Database



Open MySQL Workbench or the MySQL command line and run:



CREATE DATABASE db\_demo;



You can verify that the database was created using:



SHOW DATABASES;



\## Database Configuration



The database configuration is stored in:



src/main/resources/db.properties



Example:



db.url=jdbc:mysql://localhost:3306/db\_demo

db.username=root

db.password=xxxxxxxx



Replace xxxxxxxx with your local MySQL password.



IMPORTANT:

The actual db.properties file contains database credentials, so it should NOT be committed to Git.



The project provides:



src/main/resources/db.properties.example



as a safe template.



\## How to Run the Project



\### 1. Clone the Repository



Clone the project from Git:



git clone <repository-url>



\### 2. Open the Project



Open the project in IntelliJ IDEA.



\### 3. Configure MySQL



Make sure MySQL is installed and running.



Create the database:



CREATE DATABASE db\_demo;



\### 4. Configure Database Properties



Create:



src/main/resources/db.properties



and add your local MySQL credentials:



db.url=jdbc:mysql://localhost:3306/db\_demo

db.username=root

db.password=xxxxxxxx



\### 5. Load Maven Dependencies



Open the Maven panel in IntelliJ IDEA and reload the Maven project.



Maven will download the required dependencies defined in pom.xml.



\### 6. Configure Tomcat



Configure Apache Tomcat11 as the application server in IntelliJ IDEA.



Start the application using the Tomcat configuration.



\### 7. Open the Application



Once Tomcat starts successfully, open the application in a browser using the configured application context.



Example:



http://localhost:8080/<application-context>



\## Project Structure



spring-mvc-hibernate-crud/

|

|-- README.md

|-- pom.xml

|-- .gitignore

|

|-- src/

|

|-- main/

|

|-- java/

|   |

|   |-- com/example/

|       |

|       |-- config/

|       |   |-- DatabaseConfig.java

|       |

|       |-- controller/

|       |

|       |-- dao/

|       |

|       |-- model/

|       |

|       |-- service/

|

|-- resources/

|

|-- db.properties

|-- db.properties.example



\## Git and Security



Sensitive database credentials should never be committed to the repository.



The following file is ignored by Git:



src/main/resources/db.properties



Developers should use:



src/main/resources/db.properties.example



as a template and provide their own local database credentials.



The Maven target/ directory and IntelliJ-generated files are also excluded using .gitignore.



\## Summary



This project demonstrates a Spring MVC application that performs CRUD (Create, Read, Update, Delete) operations using Hibernate/JPA and a MySQL database.



The application follows the MVC (Model-View-Controller) architecture to separate the data/model layer, user interface, and request-handling logic, making the application more organized and maintainable.



