# Amazon automation testing framework 

A Selenium WebDriver automation testing framework built using Java, Maven,
TestNG, and Page Object Model (POM) to automate key Amazon e-commerce
workflows.

## Note -
 - It  has a method placeOrder() don not use that method , it will order the product in your account , be aware of that . It is just for automation purpose. 


##Technologies used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git
- GitHub


## Project Overview

This project automates selected Amazon e-commerce workflows using Selenium
WebDriver and follows the Page Object Model design pattern.

The framework separates:
-  Page-specific locators and actions
- Test cases
-  WebDriver management
- Configuration
- Test data
-  Wait utilities
-  Screenshots
- TestNG listeners
-  Retry handling

The goal of the project is to demonstrate a clean and maintainable
automation framework structure rather than simply creating individual
Selenium scripts.


## Automated Test Modules

The following workflows are covered in the project:

- Login
- Product Search
- Product Details
- Add Product to Cart
- Remove Product from Cart
- Checkout
- Logout

---

## Framework features
- Page Object Model (POM)
- Centralized WebDriver management
- Support for Chrome, Firefox, and Edge
- Explicit wait utility
-  Centralized framework constants
- Configuration management using properties files
- External test data management
- Screenshot capture on test failure
- TestNG listener
- Retry mechanism for failed tests
- Smoke test grouping
- Regression test grouping
-  Maven project structure
-  GitHub-ready configuration

---

## Project Structure

AmazonAutomation/
│
├── src/
│   │
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── company/
│   │   │           ├── project/
│   │   │           │   ├── base/
│   │   │           │   │   ├── BasePage.java
│   │   │           │   │   └── DriverManager.java
│   │   │           │   │
│   │   │           │   ├── constants/
│   │   │           │   │   └── FrameworkConstants.java
│   │   │           │   │
│   │   │           │   └── pages/
│   │   │           │       ├── HomePage.java
│   │   │           │       ├── LoginPage.java
│   │   │           │       ├── RegistrationPage.java
│   │   │           │       ├── SearchResultsPage.java
│   │   │           │       ├── ProductDetailsPage.java
│   │   │           │       ├── CartPage.java
│   │   │           │       └── CheckoutPage.java
│   │   │           │
│   │   │           └── projects/
│   │   │               ├── listeners/
│   │   │               │   ├── TestListener.java
│   │   │               │   └── RetryAnalyzer.java
│   │   │               │
│   │   │               └── utils/
│   │   │                   ├── ConfigReader.java
│   │   │                   ├── TestDataReader.java
│   │   │                   ├── WaitUtils.java
│   │   │                   └── ScreenshotUtils.java
│   │   │
│   │   └── resources/
│   │       └── Config.properties
│   │
│   └── test/
│       │
│       ├── java/
│       │   └── com/
│       │       └── company/
│       │           └── project/
│       │               └── tests/
│       │                   ├── BaseTest.java
│       │                   ├── LoginTest.java
│       │                   ├── SearchTest.java
│       │                   ├── ProductTest.java
│       │                   ├── CartTest.java
│       │                   ├── CheckoutTest.java
│       │                   └── LogOutTest.java
│       │
│       └── resources/
│           ├── testdata.properties
│           └── testdata.example.properties
│
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md


# Feature improvements
 - Parallel test execution
 - Cross-browser execution through Maven parameters
 - CI/CD integration
 - GitHub Actions
 - Additional Amazon workflows
 - Advanced reporting
 - Logging framework integration
 - Additional test coverage