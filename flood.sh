#!/bin/bash

for i in {1..1050}
do
  curl -s -X POST http://localhost:8080/logs \
  -H "Content-Type: application/json" \
  -d "{\"service\":\"test-service\",\"level\":\"INFO\",\"message\":\"Log number $i\"}" &
done

wait
