
# REST API Service for Transactions

This Spring Boot project provides a RESTful API for managing financial transactions. It includes endpoints for creating transactions, filtering transactions by amount range, and sorting transactions by amount.

### Prerequisites

Before running the application, ensure you have the following dependencies installed:

 - Java 17 or later
 - Maven (for building the project)
 - Spring Web, Spring Data JPA, Lombok
 - H2 Database (embedded database for testing)

### Getting Started

- Clone this repository to your local machine.
- Navigate to the project root directory.
- Run this application (The application will start on port 8080 by default.)

## Endpoints
#### 1) Create Transaction (POST)
- Endpoint: 

    ````bash
      POST /txn/add
    ````
- Description: Create a new transaction.
- Request body (eg:)

```bash
    {
      "txnId": "74001755",
      "customerName": "John",
      "service": "UPI",
      "amount": 3548,
      "gst": 0.18,
      "commission": 10
    }
```
- Response: HTTP status 200 (Created) if successful.

#### 2) Filter Transactions by Amount Range (GET)
- Endpoint:

    ````bash
      GET /txn/amount/{initial_range}/{final_range}
    ````
- Description: Retrieve transactions within the specified amount range.
- Example: `/txn/amount/50/200` retrieves transactions with amounts between 50 and 200.
- Response:
   - List of transactions within the specified range.
   - HTTP status 200 (OK) if transactions exist.
   - HTTP status 400 (Bad Request) if the range is invalid or no transactions are found.

#### 3) Sort Transactions by Amount (GET)
- Endpoint:

   ````bash
      GET /txn/sort/amount
   ````
- Description: Retrieve transactions sorted by amount in ascending order.
- Response:
   - List of transactions sorted by amount.
   - HTTP status 200 (OK) if transactions exist.
   - HTTP status 400 (Bad Request) if no transactions are found.

## Database Configuration
The application uses an H2 in-memory database for testing. You can configure a different database for production use by updating the application.yml file.
