# Pharmacy Management System
# Author: Jeff woolridge

A simple Java application to manage drugs and patients using **file I/O** and **PostgreSQL database**. This project demonstrates object-oriented programming, JDBC database connectivity, and basic file handling in Java.

---

## Features

- **Drug Management (File-based)**  
  - Save drug data to a text file (`drugs.txt`)  
  - Read all drug data from the text file  

- **Patient Management (Database-based)**  
  - Save patient data to a PostgreSQL database  
  - Read all patient data from the database  

- **Menu-based Interface**  
  - Simple console menu using `Scanner`  
  - Input validation for numerical and string data  

---

## Entity Classes

1. **Drug**
   - `drugId` (String)  
   - `drugName` (String)  
   - `drugCost` (double)  
   - `dosage` (String)  

2. **Patient**
   - `patientId` (String)  
   - `patientFirstName` (String)  
   - `patientLastName` (String)  
   - `patientDOB` (String, format `YYYY-MM-DD`)  

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd JavaQAP4
```

### 2. Create Database
```sql
CREATE DATABASE pharmacydb;
```

### 3. Create Table
```sql
CREATE TABLE patients (
    patient_id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE
);
```

### 4. Update DatabaseHandler.java with your PostgreSQL credentials:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/pharmacydb";
private static final String USER = "yourusername";
private static final String PASSWORD = "yourpassword";
```

### 5.  Compile the program
```bash
javac *.java
```

### 6.  Run the program
```bash
java Main
```
