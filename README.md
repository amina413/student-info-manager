# Student Info Manager

[![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java)](https://www.oracle.com/java/)
[![MongoDB](https://img.shields.io/badge/Database-MongoDB-green?logo=mongodb)]
[![Platform](https://img.shields.io/badge/Platform-Console-lightgrey)]

Manage student records easily through a Java console application.  
Supports adding, viewing, searching students, and storing data both locally (JSON) and remotely (MongoDB Atlas).

---

##  Features
-  Add new students (ID, Name, Email, Course)
-  View all saved students
-  Search for a student by ID
-  Save and load student data from a JSON file
-  Connect and sync student records to MongoDB Atlas

---

##  Getting Started

### Prerequisites
- Java 17 or higher installed
- Internet connection
- MongoDB Atlas account
- MongoDB Java Driver (already included)

Open the project in IntelliJ IDEA (or your preferred Java IDE).

Ensure your MongoDB URI is correctly set inside DatabaseManager.java.

Run Main.java to start the app.


### Installation
```bash
git clone https://github.com/amina413/student-info-manager.git
cd student-info-manager
```

 ## How to Use

When you run the application, a simple console menu will appear:

| Option | Description |
|:------|:------------|
| **1. Add Student** | Enter ID, Name, Email, and Course for a new student. |
| **2. View All Students** | Display all saved student records. |
| **3. Search Student by ID** | Retrieve a student's information by entering their ID. |
| **4. Exit** | Safely close the application. |


## Project Structure

```plaintext
student-info-manager/
├── src/
│   ├── DatabaseManager.java
│   ├── JsonManager.java
│   ├── Main.java
│   ├── Student.java
│   └── StudentManager.java
├── students.json
├── README.md
```


## Built With

- Java 17
- MongoDB Atlas – cloud database storage
- Gson – JSON file handling


## Sample Data

- The students.json file contains sample students you can immediately test with.


## Author

| Name  | GitHub |
|:------|:-------|
| Amina | [amina413](https://github.com/amina413) |


## Notes: 
If your MongoDB Atlas cluster is offline, the application will still run using the students.json file.



