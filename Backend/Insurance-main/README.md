# Suggestion Application

The Suggestion Application is a web application built using Spring Boot and React. It allows users to submit suggestions and view existing suggestions.

## Features

- User Registration: Users can create an account to submit and manage their suggestions.
- Suggestion Submission: Authenticated users can submit suggestions by providing a title and description.
- Suggestion Listing: Users can view a list of all suggestions, including the title, description, and author.
- User Authentication: The application provides user authentication and authorization to ensure secure access to the features.

## Technologies Used

- Backend:
  - Java
  - Spring Boot
  - Spring Security
  - Spring Data JPA
  - MySQL (or any other database of your choice)

- Frontend:
  - JavaScript
  - React
  - React Router
  - Axios (for API calls)
  - HTML/CSS

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/suggestion-application.git
   ```

2. Backend Setup:
   - Open the terminal and navigate to the project's backend directory.
   - Run the Spring Boot application using the following command:

     ```bash
     ./mvnw spring-boot:run
     ```

3. Frontend Setup:
   - Open the terminal and navigate to the project's frontend directory.
   - Install the dependencies using npm:

     ```bash
     npm install
     ```

   - Start the React development server:

     ```bash
     npm start
     ```

4. Access the application:
   - Open your web browser and navigate to `http://localhost:3000` to access the Suggestion Application.

## API Endpoints

The following are the API endpoints provided by the backend:

- `POST /plans`: Create a new suggestion.
- `GET /plans`: Get a list of all suggestions.

Feel free to customize the application based on your specific requirements and add additional features if needed.

## Clean Content Endpoint

To access the clean content endpoint, you can use the following URLs:

- `POST http://localhost:8080/plans`: Submit a new suggestion.
- `GET http://localhost:8080/plans`: Retrieve all suggestions.

Make sure to replace `localhost:8080` with the appropriate hostname and port if you have configured your backend to run on a different address.

Remember to set the appropriate request headers and body content when making API calls.

