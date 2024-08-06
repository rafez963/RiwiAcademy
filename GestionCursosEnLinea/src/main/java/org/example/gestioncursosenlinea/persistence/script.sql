
##Create the Database

CREATE DATABASE RiwiAcademyDB;
USE RiwiAcademyDB;


## Create Tables
## Students Table
CREATE TABLE Students (
    student_ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'

);


## Courses Table
CREATE TABLE Courses (
    course_ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE COLLATE utf8mb4_bin,
    description TEXT
);


## Enrollments Table
CREATE TABLE Enrollments (
    enrollment_ID INT AUTO_INCREMENT PRIMARY KEY,
    student_ID INT,
    course_ID INT,
    enrollment_date DATE,
    FOREIGN KEY (student_ID) REFERENCES Students(student_ID) ON DELETE CASCADE,
    FOREIGN KEY (course_ID) REFERENCES Courses(course_ID) ON DELETE CASCADE,
    CONSTRAINT uc_student_course UNIQUE (student_ID, course_ID)
);


##Grades Table
CREATE TABLE Grades (
    grade_ID INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_ID INT,
    grade DECIMAL(5, 2) CHECK (grade BETWEEN 0 AND 100),
    description TEXT,
    FOREIGN KEY (enrollment_ID) REFERENCES Enrollments(enrollment_ID) ON DELETE CASCADE
);


