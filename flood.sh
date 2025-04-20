#!/bin/bash
for i in {1..10}
do
  curl -s -X POST http://localhost:8080/logs \
  -H "Content-Type: application/json" \
  -d "{\"service\":\"retry-test\",\"level\":\"INFO\",\"message\":\"Log $i\"}" &
done

wait
