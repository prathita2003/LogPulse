# LogPulse – Log Monitoring & Alerting System

LogPulse is a full-stack log monitoring and alerting system built using Spring Boot and React. It ingests logs, analyzes them using configurable rules, and generates alerts based on thresholds and time-window conditions.

---

## Screenshots

### Dashboard Overview

[Insert Screenshot Here – Full Dashboard UI]

### Logs Table

[Insert Screenshot Here – Logs Display]

### Alerts Panel

[Insert Screenshot Here – Alerts Generated]

### Rule Creation

[Insert Screenshot Here – Rule Creation Form]

---

## Features

* Log ingestion via REST API
* Real-time log visualization
* Rule-based alert generation
* Time-window based filtering
* Dynamic alert rule configuration via UI
* Filtering logs by level and service
* Optimized database queries (no in-memory filtering)

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* MySQL

### Frontend

* React.js
* Axios

---

## Architecture

```
React UI
   ↓
Spring Boot REST API
   ↓
Service Layer (Rule Engine)
   ↓
Repository Layer (JPA)
   ↓
MySQL Database
```

---

## Project Structure

```
logpulse/
├── backend/
│   ├── src/main/java/com/logpulse/
│   ├── src/main/resources/
│   └── pom.xml
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
└── README.md
```

---

## How to Run

### Backend

```
cd backend
mvn spring-boot:run
```

---

### Frontend (Development Mode)

```
cd frontend
npm install
npm start
```

---

### Production Mode (Single URL)

```
cd frontend
npm run build
```

Copy contents of `frontend/build/` into:

```
backend/src/main/resources/static/
```

Then run:

```
mvn spring-boot:run
```

Open:

```
http://localhost:8080
```

---

## Sample API Request

POST `/logs`

```json
{
  "service": "payment-service",
  "level": "ERROR",
  "message": "Transaction failed"
}
```

---

## Design Decisions

* Used ENUM for log levels to ensure type safety
* Replaced in-memory filtering with database-level queries
* Implemented rule-based alerting using time-window evaluation
* Prevented duplicate alerts using recent alert checks

---

## Future Improvements

* Streaming ingestion using Kafka
* Real-time updates using WebSockets
* Authentication and role-based access
* Containerized deployment using Docker

---
## Deployment

* **Live Demo (Render):** [Insert Render Deployment Link Here]
* **Cloud Deployment (AWS EC2):** [Insert AWS EC2 Deployment Link Here]

---
## Author

Your Name
