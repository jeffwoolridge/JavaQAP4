-- create_patients_table.sql

-- Create database (optional if not already created)
-- CREATE DATABASE pharmacydb;

-- Connect to your database
-- \c pharmacydb;

-- Drop table if it already exists
DROP TABLE IF EXISTS patients;

-- Create the patients table
CREATE TABLE patients (
    patient_id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);

-- Optional: insert sample data
INSERT INTO patients (patient_id, first_name, last_name, dob)
VALUES 
('P1', 'Jeff', 'Woolridge', '1990-06-17'),
('P2', 'Alice', 'Smith', '1985-02-25');
