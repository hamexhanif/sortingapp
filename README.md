# SortingApp

A Web Service made with Spring Boot for Sorting Arbitrary Long Lists of Floating-point Numbers.

Three different sorting algorithms are available:
- Bubble Sort
- Merge Sort
- Quick Sort

## Prerequisite

- Java 21 or higher
- Maven 3.9.8

## Building the Project

1. Clone the repository
```bash
git clone https://github.com/hamexhanif/sortingapp.git
cd sort-service
```

2. Compile the project
```bash
mvn clean package
```

## Generating an SSL Certificate

Before the first start, you need to create an SSL certificate:

```bash
keytool -genkey -alias sortingapp_cert -keyalg RSA -keystore certificate.p12 -storetype PKCS12 -validity 365 -dname "CN=Muhammad Hanif, O=Energy, O=Fraunhofer, L=Dresden, S=Saxony, C=DE"
```
When prompted, enter a password and confirm the certificate details. The one used in the exsiting repository is `thisisthepassword`, configurable in `application.properties`

After the certificate `certificate.p12` generated, put it in the `src/main/resources` directory.

## Starting the Application

```bash
mvn spring-boot:run
```

The service will then running at `https://localhost:8100`

## API Endpoints

All endpoints accept POST requests with a JSON array of floating-point numbers.

### Bubble Sort
- URL: `/api/sort/bubblesort`
- Method: POST
- Example Request:
```json
[5.5, 3.2, 1.1, 4.4]
```

### Merge Sort
- URL: `/api/sort/mergesort`
- Method: POST
- Example Request:
```json
[5.5, 3.2, 1.1, 4.4]
```

### Quick Sort
- URL: `/api/sort/quicksort`
- Method: POST
- Example Request:
```json
[5.5, 3.2, 1.1, 4.4]
```

## Example Using cURL

```bash
curl -k -X POST https://localhost:8100/api/sort/mergesort -H "Content-Type: application/json" -d "[5.5, 3.2, 1.1, 4.4]"
```

## Configuration

Configuration settings are located in `application.properties`:
- Port: 8100
- HTTPS Configuration
- Logging Configuration

## Running Tests

```bash
mvn test
```

## Debug Mode

Enable debug mode to view the duration and a detailed breakdown of the sorting process. To do so, uncomment the `# spring.profiles.active=debug` line in the `application.properties` file or start the application with the following command:

```bash
mvn spring-boot:run -Dspring.profiles.active=debug
```
