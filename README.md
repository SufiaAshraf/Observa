# 🛠️ Observa: Lightweight Log Aggregation + AI Insights

**Observa** is a minimalist, log aggregation system inspired by tools like Splunk. It supports log ingestion via API, in-memory storage, filtering, retry logic, and now integrates powerful AI-driven insights and alerting features using open-source LLMs.

---

## 🚀 Features

### 🔄 Core Log System
- `POST /logs` — Send logs to system
- `GET /logs` — Retrieve logs (with filters: `service`, `level`)
- Built-in **Blocking Queue** with retry queue
- **In-memory log storage** with modular storage interface
- Unique `requestId` tracking in every API call

### 🧠 AI-Powered Capabilities
- `POST /logs/summary` — Summarize logs using local LLM (Mistral)
- `POST /logs/root-cause` — Estimate root cause from recent failures
- `POST /logs/chat` — Chat with your logs ("What happened in auth-service yesterday?")

### 🚨 Alerting & Metrics
- `POST /alerts/rules` — Add alert rule in natural language
- `GET /alerts/triggered` — View triggered alerts
- `GET /logs/metrics` — View per-service log stats
- `GET /logs/daily-digest` — Daily AI summary of logs

---

## 📂 Project Structure

```
com/
└── observa/
    ├── controller/        # REST endpoints
    ├── service/           # Business logic
    ├── storage/           # In-memory log store
    ├── queue/             # LogQueue and RetryQueue
    ├── model/             # LogMessage, AlertRule etc.
    ├── dto/               # Request and response DTOs
    ├── filter/            # RequestIdFilter
    ├── util/              # PromptLoader and utilities
    ├── prompts/           # AI prompt templates
    └── ObservaApplication.java
```

---

## 📬 API Reference

| Endpoint | Method | Sample Request | Sample Response |
|----------|--------|----------------|-----------------|
| `/logs` | POST | `{ "service": "auth-service", "level": "ERROR", "message": "JWT expired" }` | `"Log received."` |
| `/logs` | GET | `/logs?service=auth-service&level=ERROR` | `[ { ... LogMessage } ]` |
| `/logs/summary` | POST | `{ "service": "payment-service" }` | `"Summary of log activity in payment-service..."` |
| `/logs/root-cause` | POST | `{ "service": "inventory-service" }` | `"Likely root cause: database latency..."` |
| `/logs/chat` | POST | `{ "query": "What happened in auth-service yesterday?" }` | `"There were 3 login failures and a token mismatch..."` |
| `/alerts/rules` | POST | `{ "service": "payment-service", "level": "ERROR", "threshold": 3, "windowMinutes": 10 }` | `"Alert rule added"` |
| `/alerts/triggered` | GET |  — | `[ { "service": "payment-service", "level": "ERROR", "message": "Triggered: 4 logs in 10 min" } ]` |
| `/logs/metrics` | GET | — | `{ "auth-service": { "INFO": 10, "ERROR": 5 }, ... }` |
| `/logs/daily-digest` | GET | — | `"Yesterday's summary: 5 auth failures, 2 payment errors..."` |

---

## 🔁 Retry Queue

If the log queue is full, logs are pushed to a retry queue. Background worker retries every 2s.

---

## 🧠 Local LLM Setup (Mistral)

You can run this app with [Ollama](https://ollama.com) and the `mistral` model:

```bash
ollama run mistral
```

App will call Ollama's API on `http://localhost:11434`.

---

## 🌅 Future Scope

- Save logs in persistent DB (Postgres, Mongo)
- Web UI for visualization
- Alerts via Email / Slack
- Schedule-based insights & metrics
- Fine-tuned log classification models

---

## 👩‍💻 Built by @Sufia as a system design + AI exploration ✨
