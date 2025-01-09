# Pet Application with simple CRUD

This is a Spring Boot application
for managing pet records, providing a CRUD
(Create, Read, Update, Delete) API.
Built using Java, the Springboot framework and postgresql for persistent storage.

## Prerequisites

- **Java 17 or higher**
- **PostgreSQL**

### API Endpoints

| Method | Endpoint                   | Description                 |
|--------|----------------------------|-----------------------------|
| POST   | /api/expense/create        | create an expense           |
| GET    | /api/expense/listAll       | return all expenses from DB |
| GET    | /api/expense/{id}          | return expense by id        |
| POST   | /api/expense/delete/{id}   | delete expense by id        |
| POST   | /api/expense/update        | update expense              |
| GET    | /api/report/generateReport | get report                  |