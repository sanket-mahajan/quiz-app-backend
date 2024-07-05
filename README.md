# Quiz App Backend

This is the backend part of the Quiz App, built with Spring Boot. The application provides RESTful APIs for managing quizzes and questions.

## Features

- Fetch all questions
- Add a new question
- Delete a question
- Update a question
- Create quizzes
- Fetch quizzes by ID
- Submit quizzes and get results

## Technologies Used

- Spring Boot
- JPA/Hibernate
- MySQL
- Lombok
- Maven

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 21.0.2
- MySQL

### Installation

1. Clone the repository:

   git clone https://github.com/yourusername/quiz-app-backend.git
   cd quiz-app-backend

2. Configure the database:

   spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update

3. Install the dependencies and build the project:

   mvn clean install

Running the Application:

1. Start the Spring Boot application:

   mvn spring-boot:run

2. The backend server will start on http://localhost:8080.

## API Endpoints

### Question Endpoints

- Get all questions: GET /question/allQuestions
- Add a new question: POST /question/add

      Request Body :

      {
        "questionTitle": "What is Java?",
        "option1": "Programming Language",
        "option2": "Operating System",
        "option3": "Web Browser",
        "option4": "Database",
        "rightAnswer": "Programming Language",
        "difficultyLevel": "Easy",
        "category": "Programming"
       }
