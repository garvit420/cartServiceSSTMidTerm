
# Cart Service

This is a Spring Boot application that functions as a Cart Service, which internally makes API calls to the Fake Store API.

## Project Setup

1. Initialize a new Spring Boot project.
This is a Spring Boot application that functions as a Cart Service, which internally makes API calls to the Fake Store API.

## Running the Application

To run the application, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
The application is organized following the MVC (Model-View-Controller) pattern.

## Running the Application

3. Run the command `mvn spring-boot:run`.


## Running Tests

To run the tests, use the command `mvn test`.

## API Endpoints

The application provides the following endpoints:

- `GET /carts`: Get all carts.
- `GET /carts/{id}`: Get a cart by its ID.
- `GET /carts/{startDate}/{endDate}`: Get carts by a date range.
- `GET /carts/user/{userId}`: Get carts by a user ID.
- `POST /carts`: Create a new cart.
- `PUT /carts/{id}`: Update an existing cart.
- `DELETE /carts/{id}`: Delete a cart.


