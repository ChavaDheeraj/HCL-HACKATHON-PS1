# E-Commerce Test Automation Framework (Selenium + TestNG)

## Project Overview

This project is a Selenium-Java Automation Framework designed for testing an E-Commerce web application using the Page Object Model (POM). It provides end-to-end automation for authentication, product management, cart operations, and checkout flows.

## Tech Stack

- Java 11
- Selenium WebDriver 4.21.0
- TestNG 7.10.2
- WebDriverManager 5.8.0
- Apache POI (Excel Data Driven)
- ExtentReports 5.1.1

## Framework Features

- Page Object Model (POM) Design Pattern
- Data-driven testing using Excel
- Config-based execution (Browser, URL, Timeout)
- Automatic screenshot capture on failure
- Extent HTML reporting
- Thread-safe Parallel execution
- Automatic retry mechanism for flaky tests
- Headless execution support for CI/CD

## Test Coverage

### 1. Authentication
- Login (Valid and Invalid credentials)
- Signup (Using DataProvider)
- Logout and session management

### 2. Product Module
- Product search by keyword
- Browsing categories
- Verifying product details (Name, Price)

### 3. Shopping Cart
- Adding products to cart
- Removing products from cart
- Cart count verification

### 4. Checkout Flow
- Complete checkout process with payment
- Checkout validation for guest users

### 5. Form Validation
- Handling empty fields
- Invalid email format validation

## Setup Instructions

### 1. Clone the repository
git clone <repo-url>

### 2. Install dependencies
mvn clean install

### 3. Run tests
mvn test

## Configuration

The framework settings can be adjusted in:
src/main/resources/config.properties

Key settings:
- browser: chrome or firefox
- baseUrl: target application URL
- timeout: explicit wait duration
- headless: true or false

## Reports and Artifacts

- Test Reports: reports/ExtentReport.html
- Screenshots: screenshots/
- CI/CD Workflow: .github/workflows/test.yml
