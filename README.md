# automationexercise.com Web Automation

This repository contains an automated web testing project for automationexercise.com, utilizing Selenium, Java, TestNG, and the Page Object Model (POM) framework. The project is structured based on Maven architecture.

## Project Structure

- **BrowserConfig Package**: Contains the `BaseDriver` class where all web drivers are initialized.
- **Pages Package**: Contains page classes with WebElements and methods for each page.
- **Test Package**: Contains test classes for all pages.

## Technologies Used

- **Selenium**: [Selenium](https://www.selenium.dev/) is used for web automation.
- **Java**: [Java](https://www.java.com/) is the programming language used for automation.
- **TestNG**: [TestNG](https://testng.org/) is used for test management and parallel execution.
- **Maven**: [Maven](https://maven.apache.org/) is the build automation and dependency management tool used for the project.

## Maven Dependencies

The project's Maven dependencies are listed in the [pom.xml](./pom.xml) file.

## Reports

- **Emailable Report**: An [emailable report](path/to/emailable/report) is generated for test results.
- **Testing Failed Report**: A [report](path/to/failed/report) highlighting failed test cases is generated.

## How to Run

1. Ensure you have the necessary tools and dependencies installed.
2. Clone the repository: `git clone https://github.com/your-username/automationexercise-web-automation.git`
3. Navigate to the project directory: `cd automationexercise-web-automation`
4. Open the project in any IDE (intelliJ, Eclipse etc.)
5. Run the tests

Feel free to customize and extend this automation framework according to your specific requirements.

For any questions or issues, please [open an issue](https://github.com/An-Nihal/automationexercise-web-automation/issues).
