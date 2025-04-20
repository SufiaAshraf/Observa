#!/bin/bash

ENDPOINT="http://localhost:8080/logs"

declare -a logs=(
  # Auth Service
  '{"service":"auth-service", "level":"INFO", "message":"User 983 logged in successfully"}'
  '{"service":"auth-service", "level":"ERROR", "message":"JWT expired for user 983"}'
  '{"service":"auth-service", "level":"WARN", "message":"Login attempt with deprecated token"}'
  '{"service":"auth-service", "level":"ERROR", "message":"Token signature mismatch for user 942"}'
  '{"service":"auth-service", "level":"INFO", "message":"Password reset initiated for user 784"}'

  # Payment Service
  '{"service":"payment-service", "level":"INFO", "message":"Payment processed for order #456"}'
  '{"service":"payment-service", "level":"ERROR", "message":"Timeout while calling Stripe API"}'
  '{"service":"payment-service", "level":"WARN", "message":"Unusual payment pattern detected"}'
  '{"service":"payment-service", "level":"ERROR", "message":"Payment declined due to insufficient funds"}'
  '{"service":"payment-service", "level":"INFO", "message":"Refund issued for transaction ID TXN123"}'

  # Inventory Service
  '{"service":"inventory-service", "level":"INFO", "message":"Stock updated for SKU-1234"}'
  '{"service":"inventory-service", "level":"ERROR", "message":"Stock not available for SKU-9823"}'
  '{"service":"inventory-service", "level":"WARN", "message":"Inventory sync delayed with supplier"}'
  '{"service":"inventory-service", "level":"ERROR", "message":"Database deadlock during stock update"}'

  # Notification Service
  '{"service":"notification-service", "level":"INFO", "message":"Email sent to user@example.com"}'
  '{"service":"notification-service", "level":"ERROR", "message":"SMS delivery failed"}'
  '{"service":"notification-service", "level":"INFO", "message":"Push notification sent for app update"}'
  '{"service":"notification-service", "level":"WARN", "message":"High bounce rate in email campaign"}'

  # Analytics Service
  '{"service":"analytics-service", "level":"DEBUG", "message":"User session tracked"}'
  '{"service":"analytics-service", "level":"WARN", "message":"Event processing delay detected"}'
  '{"service":"analytics-service", "level":"ERROR", "message":"Failed to store daily usage metrics"}'
  '{"service":"analytics-service", "level":"INFO", "message":"Generated report for usage trends"}'

  # Search Service
  '{"service":"search-service", "level":"INFO", "message":"Search results delivered in 45ms"}'
  '{"service":"search-service", "level":"ERROR", "message":"Elasticsearch cluster timeout"}'
  '{"service":"search-service", "level":"WARN", "message":"Frequent retries detected in search API"}'
)

echo "Sending logs to $ENDPOINT..."

for log in "${logs[@]}"
do
  echo "Posting: $log"
  curl -s -X POST "$ENDPOINT" \
    -H "Content-Type: application/json" \
    -d "$log"
  echo ""
done

echo "Log seeding complete!"
