# 🚀 Currency Converter Challenge

This project is a console application developed in Java that enables users to convert amounts between major world currencies, utilizing real-time exchange rate data from an external API.

This application was developed as part of the **Oracle ONE Next Education (ONE) program by Alura Latam**.

---

## 💻 Technologies and Tools

| Category | Element | Usage and Rationale |
| :--- | :--- | :--- |
| **Language** | **Java 25** (JDK 25) | Core programming language. Utilizes modern Java features like **records** and the native **`HttpClient`** for efficient, modern code. |
| **Dependency Management**| **Apache Maven** | Used for managing dependencies (Gson) and building the project, ensuring portability and clean structure. |
| **External Library**| **Gson 2.10.1** | Google's library for the serialization and deserialization of JSON data, mapping API responses to Java records. |
| **API Connection**| **`java.net.http.HttpClient`** | Java's native HTTP module used to perform secure GET requests to the external exchange rate API. |
| **Security** | **Environment Variables (`.env`)** | Implements best practices to protect the confidential API key (`EXCHANGERATE_API_KEY`) by excluding it from the Git repository. |

---

## 🧭 Application Features

The program runs in a continuous loop, allowing the user to perform multiple conversions until they choose to exit.

1.  **Real-Time Query:** Fetches current exchange rate data from the **ExchangeRate-API** service.
2.  **Pair Conversion:** Allows conversion from a base currency (e.g., MXN) to a target currency (e.g., EUR).
3.  **Fixed Menu Interface:** Guides the user through a pre-defined menu of major currencies (e.g., USD, EUR, MXN, BRL) to ensure valid input.
4.  **Robust Error Handling:** Utilizes `try-catch` blocks to gracefully handle connection failures, invalid API keys, and non-numeric user inputs.
5.  **Supported Currencies:** MXN, USD, EUR, GBP, ARS, BRL.

---

## 🛠️ Project Structure (OOP & SRP)

The project adheres to the Single Responsibility Principle (SRP) for clean and maintainable object-oriented code:

* `Main.java`: **Orchestration.** Manages the console interface, user input (`Scanner`), and application flow.
* `models/CurrencyApiResponse.java`: **Data Model.** A Java **Record** used to map the nested JSON structure of the API response (`Map<String, Double> conversionRates`).
* `service/CurrencyQuery.java`: **API Access.** Handles URI construction, `HttpClient` communication, and returns the data object.
* `service/ConvertCurrency.java`: **Business Logic.** Receives the data object and performs the core conversion calculation (`monto * factor`).

---

## ⚙️ Getting Started

To run this project, you will need Java 25 and your personal API key.

### 1. Prerequisites

* **Java JDK 25** (or newer).
* **Apache Maven** (for dependency and build management).
* A free API key from [ExchangeRate-API](https://www.exchangerate-api.com/).

### 2. Configure Credentials

Create a file named **`.env`** in the root directory of the project and define your API key:

```env
EXCHANGERATE_API_KEY="YOUR_PERSONAL_API_KEY_HERE"
```
## ⚙️ Build and Run

Use the standard Maven commands to compile and execute the application from your project's root directory:

* **Compilation and Dependencies:**
    ```bash
    mvn clean install
    ```
  (This command compiles the code and downloads dependencies, such as Gson.).

* **Application Execution:**
    ```bash
    mvn exec:java -Dexec.mainClass="com.aluracursos.conversor.Main"
    ```
  (This command executes the application's main class).