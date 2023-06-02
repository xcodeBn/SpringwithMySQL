


# Employee Management System API w/SpringBoot&MySql

This is a RESTful API for managing employees in a company. It is developed using Spring Boot and utilizes a local MySQL database for data storage.

## Features

- Create, read, update, and delete employees,industries and departments.
- Retrieve a list of all employees or search for employees by specific criteria.
- Supports basic CRUD operations for managing employee data.

## Getting Started

To get started with the Employee Management System API, follow the instructions below.

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- XAMPP or any other MySQL server installed for managing the database.

### Setup

1. Clone the repository:

   ```shell
   git clone <repository_url>
   ```
   
2. Set up the MySQL database:

Install XAMPP or any other MySQL server.
Create a new database called employee_management_system using a MySQL client or the command line.
Configure the database connection:

Open the application.properties file located in the src/main/resources directory.

Modify the following properties to match your MySQL database configuration:

properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system
spring.datasource.username=<your_database_username>
spring.datasource.password=<your_database_password>

```


3. Build and Run


```
mvn clean install

java -jar target/employee-management-system-api.jar
```

The API will be accessible at http://localhost:8080/api/v1/ 


## Contributions 

Feel free to do whatever you want with this , i don't really care it's some basic stuff for newbies :')





