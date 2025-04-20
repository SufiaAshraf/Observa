# 📊 Observa - Lightweight Log Aggregation System

**Observa** is a minimal, extensible log aggregation and monitoring system inspired by Splunk. It uses a message queue-based architecture with built-in retry logic, in-memory storage, and simple REST APIs for ingestion and retrieval.

---

## 🚀 Features

- ✅ **POST /logs**: Submit log entries
- ✅ **GET /logs**: Retrieve logs with optional filtering by `service` and `level`
- ✅ **Asynchronous Queue Processing**: Logs are enqueued and consumed in the background
- ✅ **Retry Logic**: If the main queue is full, logs are retried 3 times before falling back
- ✅ **Retry Queue**: Unprocessed logs are saved in a secondary queue for background retry
- ✅ **UUID-based Log IDs**: Each log is assigned a unique ID for traceability
- ✅ **Queue Monitoring Logs**: Periodic logging of queue and retry queue size
- ✅ **Spring Boot + Java 19**: Modern, maintainable stack

---

## 📦 Technology Stack

- Java 19
- Spring Boot 3.2
- Spring Retry
- Lombok
- Maven

---

## 🧪 Sample API Usage

### ➕ POST `/logs`

Submit a new log:

```bash
curl -X POST http://localhost:8080/logs \
-H "Content-Type: application/json" \
-d '{
  "service": "auth-service",
  "level": "ERROR",
  "message": "Token validation failed"
}'
```

#### ✅ Response:

```text
200 OK
Log received.
```

#### ❗ Possible Error:

```text
429 Too Many Requests
Temporarily overloaded. Log added to retry queue.
```

---

### 🔍 GET `/logs`

Retrieve all logs:

```bash
curl http://localhost:8080/logs
```

Filter logs by service:

```bash
curl "http://localhost:8080/logs?service=auth-service"
```

Filter logs by service and level:

```bash
curl "http://localhost:8080/logs?service=auth-service&level=ERROR"
```

---

## 📘 Log Data Structure

```json
{
  "id": "18cfa374-91fa-4a7e-8124-4b75cfddf602",
  "service": "auth-service",
  "level": "ERROR",
  "message": "Invalid credentials",
  "timestamp": 1745136251146
}
```

---

## 🔮 Future Scope

- 📈 Persistent storage (MongoDB, PostgreSQL)
- 📊 Frontend dashboard using React
- 🔁 Dead letter queue for permanently failed logs
- 🧠 Alerting & anomaly detection engine
- 📦 Dockerization and cloud deployment
- 📥 Log forwarding via Kafka or RabbitMQ
- 🔐 Auth + API rate limiting

---

## 🛠️ Setup Instructions

1. Clone the repo:
```bash
git clone https://github.com/yourusername/observa.git
cd observa
```

2. Build and run:
```bash
mvn clean install
mvn spring-boot:run
```

3. Test APIs using `curl` or Postman

---

## 🙌 Maintained by

**Sufia** – Senior Software Engineer
