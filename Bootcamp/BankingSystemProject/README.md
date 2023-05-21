Banking System
=
This is a Java/Spring Boot-based banking system that provides various account types and user roles. It allows users to manage their accounts, perform transactions, and includes features such as fraud detection and third-party integration.

Table of Contents
-
* **Features**
* **Account Types**
* **User Roles**
* **Technical Requirements**
* **Getting Started**
* **Endpoints**
* **Authentication**
* **Error Handling**
* **Testing**
* **Deployment**
* **Dependencies**

Features
-
The banking system includes the following features:

* **Account Types:** Supports four types of accounts - StudentChecking, Checking, Savings, and CreditCard.
* **User Roles:** Includes three user roles - Admins, AccountHolders, and ThirdParty.
* **Account Management:** Users can create, view, and modify their own accounts.
* **Transactions:** Account holders can transfer money between their accounts and perform transactions with other accounts.
* **Interest Calculation:** Calculates and applies interest rates based on account types (savings accounts annually, credit cards monthly).
* **Penalties:** Applies penalty fees to accounts that fall below the minimum balance.
* **Fraud Detection:** Recognizes potential fraudulent activities and freezes account status accordingly.
* **Third-Party Integration:** Allows third-party users to send and receive money to/from other accounts.

Account Types
-
The system supports the following account types:

* **Checking:** Account with a balance, secret key, primary owner, optional secondary owner, minimum balance, penalty fee, monthly maintenance fee, creation date, and status (FROZEN or ACTIVE).
* **StudentChecking:** Similar to Checking accounts but without monthly maintenance fees and minimum balances.
* **Savings:** Similar to Checking accounts with the addition of an interest rate.
* **CreditCard:** Account with a balance, primary owner, optional secondary owner, credit limit, interest rate, and penalty fee.

User Roles
-
The system includes the following user roles:

* **Admins:** Users with administrative privileges who can create new accounts.
* **AccountHolders:** Regular users who can access and manage their own accounts.
* **ThirdParty:** Users with access to the banking system through API integration.

Technical Requirements
-
The banking system meets the following technical requirements:

* Java/Spring Boot backend.
* MySQL database for data storage.
* REST API with GET, POST, PUT/PATCH, and DELETE routes.
* Authentication using Spring Security.
* Unit and integration tests.
* Robust error handling.
* Money class for currency calculations and BigDecimal for other decimal or large number math.

Getting Started
-
To get started with the banking system, follow these steps:

* Clone the repository: git clone https://github.com/SolAndrade/MidtermAssessment.git
* Configure the MySQL database settings in application.properties.
* Build the project using your preferred Java IDE or by running ./mvnw clean install in the project directory.
* Run the application using your IDE or by executing ./mvnw spring-boot:run in the project directory.
* The application will start running at http://localhost:8080.


Endpoints
-
The banking system provides the following endpoints:

* **GET /accounts:** Retrieve all accounts.
* **GET /accounts/{id}:** Retrieve account by ID. 
* **POST /accounts:** Create a new account.
* **PUT /accounts/{id}:** Update account details.
* **DELETE /accounts/{id}:** Delete an account.
* **POST /accounts/{id}/transfer:** Transfer funds between accounts.
* **GET /users/{id}/accounts:** Retrieve accounts of a specific user.

Authentication
-
The banking system uses Basic Authentication for user authentication. Users need to provide valid credentials (username and password) to access protected resources.

Error Handling
-
The system implements robust error handling to provide meaningful error responses. If an error occurs, the API returns an appropriate HTTP status code along with an error message in the response body.

Testing
-
The banking system includes unit tests and integration tests to ensure the correctness of its functionalities. You can run the tests using the following command:

    mvn test

Deployment
-
The banking system can be deployed to an external server such as Heroku or Firebase to make it accessible for public use. Detailed deployment instructions can be found in the deployment documentation.

Dependencies
-
The banking system relies on the following dependencies:

* **Spring Boot:** Java framework for building web applications.
* **MySQL:** Database management system for storing account and user data.
* **Spring Security:** Provides authentication and authorization functionalities.
* **JUnit:** Testing framework for unit testing.
* **Mockito:** Java mocking framework for unit testing.
* **Lombok:** Library for reducing boilerplate code.
* **Spring Data JPA:** Simplifies database access and data persistence.

For a complete list of dependencies and their versions, please refer to the **pom.xml** file.