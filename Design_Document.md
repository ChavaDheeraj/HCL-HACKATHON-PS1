# Test Automation Framework Design Document

## 1. Architecture Overview

The framework is built using the Page Object Model (POM) pattern to maintain a clear separation between test logic and UI interactions. This modular approach ensures scalability and ease of maintenance.

### Core Layers:
- Test Layer: Contains TestNG test classes and assertions.
- Page Layer: Contains Page Object classes with locators and action methods.
- Base Layer: Contains parent classes (BaseTest, BasePage) for setup and utility sharing.
- Utility Layer: Contains helper classes for Configuration, Reporting, Screenshots, and Excel data management.

## 2. Stability and Scaling

### Parallel Execution
The framework uses ThreadLocal<WebDriver> in the DriverFactory class to ensure thread safety during parallel execution. TestNG is configured to run tests in parallel at the 'tests' level.

### Wait Strategy
Explicit waits (WebDriverWait) are used throughout the framework. A custom handleAds() method in the BasePage automatically detects and removes intrusive ad overlays that are common on the target application, preventing ElementClickInterceptedException and other timing issues.

### Retry Mechanism
To mitigate the impact of environment instability or flaky network conditions, an IRetryAnalyzer implementation (RetryAnalyzer) is applied globally via an IAnnotationTransformer listener (AnnotationTransformer). Failed tests are automatically retried up to two times.

## 3. Configuration Management

Settings are centralized in src/main/resources/config.properties. The ConfigReader utility provides access to these properties throughout the framework. Hardcoded values are strictly prohibited in the source code.

## 4. Data Driven Testing

The framework leverages Apache POI to read test data from src/main/resources/testdata.xlsx. DataProviders in the test layer feed this data into test methods, allowing for comprehensive coverage with multiple data sets (e.g., valid/invalid login, various signup scenarios).

## 5. Reporting and Failure Analysis

### HTML Reporting
ExtentReports is integrated to generate interactive HTML reports after every execution. Reports include pass/fail status, detailed logs, and execution environment info.

### failure Screenshots
A TestNG Listener (TestListener) automatically captures a screenshot of the browser state at the exact moment of test failure. These screenshots are saved in the screenshots/ directory and embedded directly into the Extent Report.

## 6. CI/CD Integration

The project includes a GitHub Actions workflow (.github/workflows/test.yml) that automates the testing process. The pipeline handles Java environment setup, Maven dependency resolution, and headless test execution on the Ubuntu runner.
