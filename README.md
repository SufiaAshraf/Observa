# 📊 Observa

**Observa** is a lightweight and extensible log aggregation system built using **Spring Boot**.  
It provides asynchronous log ingestion, in-memory storage, and REST APIs to collect and query logs — making it a perfect starting point for building your own observability platform.

---

## 🚀 Features

- 🔁 **Asynchronous Log Queue**  
  Decouples log ingestion from processing using an in-memory blocking queue.

- 📦 **In-Memory Log Storage**  
  Fast and simple temporary log persistence for querying.

- 🌐 **RESTful APIs**
    - `POST /logs`: Ingest new logs
    - `GET /logs`: Retrieve logs with optional filters (`service`, `level`)

- 🧱 **Modular Architecture**  
  Easy to extend with metrics, alerts, persistent storage (e.g., MongoDB), or a React frontend.

---

## 🧱 Tech Stack

- **Java 19**
- **Spring Boot 3**
- **Maven**
- `LinkedBlockingQueue` for message queueing
- In-memory storage using synchronized collections

---

## 📁 Project Structure

```
observa/
├── controller/         # REST APIs
├── service/            # Background consumer thread
├── queue/              # Log queue (blocking)
├── storage/            # In-memory storage logic
├── model/              # Log data model
├── config/             # CORS, future configs
├── resources/
│   └── application.properties
└── ObservaApplication.java
```

---

## 📦 API Endpoints

### ➕ POST `/logs`
Submit a new log entry.

**Request Body (JSON):**
```json
{
  "service": "auth-service",
  "level": "INFO",
  "message": "User login successful"
}
```

---

### 🔍 GET `/logs`
Retrieve logs with optional filters.

**Query Params:**
- `service` (optional)
- `level` (optional)

**Example:**
```
GET /logs?service=auth-service&level=ERROR
```

---

## 🛠️ Running the App

### Prerequisites
- Java 17 or 19
- Maven

### Run Locally

```bash
# Build the app
mvn clean install

# Run the JAR
java -jar target/observa-1.0.0.jar
```

Then access it at: [http://localhost:8080/logs](http://localhost:8080/logs)

---

## 🌟 Coming Soon

- 📈 Metrics Dashboard (logs per service, error rates)
- 🚨 Alerting System (trigger on error spikes)
- 🗃️ Persistent Storage (MongoDB, Elasticsearch)
- 🖥️ React Frontend (for live log viewer & filters)
- 🐳 Docker Support

---

## 👩‍💻 Author

Built with 💻 by **[Sufia](https://github.com/SufiaAshraf)*

---
