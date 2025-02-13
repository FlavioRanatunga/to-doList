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
```

**Build the backend:**
```bash
mvn clean install
```

**Run the backend:**
```bash
mvn spring-boot:run
```

The backend will be running on [http://localhost:8080](http://localhost:8080).

## Frontend Setup

**Navigate to the frontend directory:**
```bash
cd frontend
```

**Install dependencies:**
```bash
npm install
```

**Run the frontend:**
```bash
npm start
```

The frontend will be running on [http://localhost:3000](http://localhost:3000).

## Usage

### Access the application:
Open your browser and navigate to [http://localhost:3000](http://localhost:3000).

### Add a new task:
Enter the task name in the input field and click "Add".

### Update a task:
Click on "Update" to mark it as done or undo.

### Delete a task:
Click the "Delete" button next to a task to remove it.

## File Structure
```
to-doList/
├── src/main/java/com/example/to_doList/  # Backend source code
├── frontend/  # Frontend source code
```

## Troubleshooting
- Ensure that the backend is running on port `8080` and the frontend is running on port `3000`.
- Check the console for any error messages and resolve them accordingly.

## Algorithms.js Usage
- node algorithm.js

[Clone using the web URL.](https://github.com/FlavioRanatunga/to-doList.git)

