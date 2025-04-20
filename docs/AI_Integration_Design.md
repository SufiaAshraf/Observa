# 🤖 AI Integration Design - Observa (Updated)

This document outlines the updated architecture and flow for integrating AI capabilities into the Observa log aggregation system. It extends Observa’s core functionality with log enrichment, summarization, and natural language querying using a locally hosted LLM (Mistral via Ollama).

---

## 🎯 Goals

- Enrich individual logs with summary, classification, and anomaly detection
- Provide natural language summaries over time ranges or services
- Answer user questions about logs using LLM
- Keep all AI logic cleanly separated and modular

---

## 🧱 Final Project Structure (AI-ready)

```
observa/
├── controller/
│   ├── LogController.java
│   └── AIController.java                 # AI endpoints handler
│
├── dto/
│   ├── LogRequest.java
│   ├── LogResponse.java
│   ├── AIAnalysisRequest.java           # Input for single log analysis
│   ├── AIAnalysisResponse.java          # Output for single log analysis
│   ├── AISummaryResponse.java           # Output for multi-log summary
│   ├── AIQueryRequest.java              # Input for natural language log queries
│   └── AIQueryResponse.java             # Answer to natural language queries
│
├── service/
│   ├── LogConsumer.java
│   ├── RetryWorker.java
│   ├── LogEnqueueService.java
│   ├── LogAIService.java                # Core AI logic (calls Mistral)
│   └── LogSummaryService.java          # Filtering logs for summary/query
```

---

## 🌐 Endpoints

### 1. `POST /logs/ai-analyze`
Enrich a single log using AI.

**Input:**
```json
{
  "service": "auth-service",
  "level": "ERROR",
  "message": "JWT expired for user 983."
}
```

**Output:**
```json
{
  "classification": "token_expiry_error",
  "summary": "JWT token expired for user authentication request.",
  "anomalous": false
}
```

---

### 2. `GET /logs/summary?service=xyz&minutes=15`

Generate a summary from recent logs of a given service.

**Output:**
```json
{
  "summary": "Most logs in auth-service relate to failed login attempts and JWT expiration issues in the last 15 minutes."
}
```

---

### 3. `POST /logs/query-ai`

Accepts natural language queries about logs.

**Input:**
```json
{
  "question": "What was the most common error in payment-service today?"
}
```

**Output:**
```json
{
  "answer": "The most frequent error in payment-service was 'Timeout connecting to Stripe'. It occurred 23 times today."
}
```

---

## 🧠 How It Works

1. `AIController` receives request
2. `LogSummaryService` fetches logs if needed (for summary/query)
3. `LogAIService` constructs prompt + sends to Mistral via Ollama (`localhost:11434`)
4. Response is parsed and returned to client

---

## 📦 Model Details

- Model: `mistralai/Mistral-7B-Instruct-v0.1`
- Runtime: [Ollama](https://ollama.com/) (local)
- API: `POST http://localhost:11434/api/generate`

---

## 🔮 Future Ideas

- Auto-enrich logs during ingestion (via `/logs`)
- Alert generation from AI analysis
- Visual dashboard for summaries and alerts
- Caching AI responses
- Offline summarization batches

