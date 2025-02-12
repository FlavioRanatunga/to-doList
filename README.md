# To-Do List Application

## Overview

This is a simple To-Do List application built with Spring Boot for the backend and React for the frontend. The application allows users to add, update, and delete tasks.

## Prerequisites

- Java 11 or higher

- Node.js and npm

- Maven

## Backend Setup

**Clone the repository:**

   ```bash

   git clone <repository-url>

   cd to-doList

   Build the backend:  

mvn clean install

Run the backend:  

mvn spring-boot:run

The backend will be running on http://localhost:8080.  

## Frontend Setup

Navigate to the frontend directory:  

cd frontend

Install dependencies:  

npm install

Run the frontend:  

npm start

The frontend will be running on http://localhost:3000.  

Usage

Access the application: Open your browser and navigate to http://localhost:3000.  

Add a new task:  

Enter the task name in the input field and click "Add".

Update a task:  

Click on update to mark it as done or undo.

Delete a task:  

Click the "Delete" button next to a task to remove it.

File Structure

to-doList/src/main/java/com/example/to_doList/ - Backend source code

my-app/ - Frontend source code

Troubleshooting

Ensure that the backend is running on port 8080 and the frontend is running on port 3000.

Check the console for any error messages and resolve them accordingly.