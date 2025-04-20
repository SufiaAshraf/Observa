#!/bin/bash

ENDPOINT="http://localhost:8080/logs"

echo "Sending logs to $ENDPOINT..."

echo "Posting: {"service": "notification-service", "level": "INFO", "message": "SMS failed [1]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "SMS failed [1]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "Payment failed [2]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "Payment failed [2]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "Session started [3]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "Session started [3]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Report generation started [4]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Report generation started [4]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "WARN", "message": "Login attempt with deprecated token [5]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "WARN", "message": "Login attempt with deprecated token [5]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "INFO", "message": "User logged in [6]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "INFO", "message": "User logged in [6]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "Stock updated [7]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "Stock updated [7]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Report generation started [8]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Report generation started [8]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "DEBUG", "message": "Stock updated [9]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "DEBUG", "message": "Stock updated [9]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "User logged out [10]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "User logged out [10]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "Email sent [11]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "Email sent [11]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "INFO", "message": "Email sent [12]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "INFO", "message": "Email sent [12]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "WARN", "message": "Stock unavailable [13]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "WARN", "message": "Stock unavailable [13]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Stock updated [14]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Stock updated [14]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "DEBUG", "message": "Payment failed [15]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "DEBUG", "message": "Payment failed [15]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "JWT expired [16]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "JWT expired [16]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "ERROR", "message": "Payment successful [17]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "ERROR", "message": "Payment successful [17]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "WARN", "message": "Payment successful [18]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "WARN", "message": "Payment successful [18]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Login attempt with deprecated token [19]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Login attempt with deprecated token [19]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "INFO", "message": "Payment failed [20]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "INFO", "message": "Payment failed [20]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Event processing delay detected [21]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Event processing delay detected [21]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "INFO", "message": "Payment failed [22]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "INFO", "message": "Payment failed [22]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "WARN", "message": "Session started [23]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "WARN", "message": "Session started [23]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "DEBUG", "message": "Unusual payment pattern detected [24]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "DEBUG", "message": "Unusual payment pattern detected [24]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "ERROR", "message": "Email sent [25]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "ERROR", "message": "Email sent [25]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "INFO", "message": "Unusual payment pattern detected [26]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "INFO", "message": "Unusual payment pattern detected [26]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "WARN", "message": "Unusual payment pattern detected [27]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "WARN", "message": "Unusual payment pattern detected [27]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Report generation started [28]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Report generation started [28]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "Report generation started [29]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "Report generation started [29]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "Stock updated [30]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "Stock updated [30]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "Report generation started [31]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "Report generation started [31]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "Session started [32]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "Session started [32]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Email sent [33]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Email sent [33]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "INFO", "message": "Payment successful [34]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "INFO", "message": "Payment successful [34]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "Payment successful [35]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "Payment successful [35]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Stock updated [36]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Stock updated [36]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "User logged in [37]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "User logged in [37]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "User logged out [38]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "User logged out [38]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "WARN", "message": "Payment failed [39]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "WARN", "message": "Payment failed [39]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "WARN", "message": "Login attempt with deprecated token [40]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "WARN", "message": "Login attempt with deprecated token [40]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "ERROR", "message": "Stock unavailable [41]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "ERROR", "message": "Stock unavailable [41]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "DEBUG", "message": "Stripe timeout [42]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "DEBUG", "message": "Stripe timeout [42]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Login attempt with deprecated token [43]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Login attempt with deprecated token [43]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "DEBUG", "message": "Event processing delay detected [44]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "DEBUG", "message": "Event processing delay detected [44]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "INFO", "message": "Payment successful [45]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "INFO", "message": "Payment successful [45]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "Event processing delay detected [46]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "Event processing delay detected [46]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Payment successful [47]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Payment successful [47]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "User logged out [48]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "User logged out [48]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "Payment successful [49]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "Payment successful [49]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "DEBUG", "message": "Email sent [50]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "DEBUG", "message": "Email sent [50]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "JWT expired [51]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "JWT expired [51]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "ERROR", "message": "JWT expired [52]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "ERROR", "message": "JWT expired [52]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Email sent [53]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Email sent [53]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "WARN", "message": "Report generation started [54]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "WARN", "message": "Report generation started [54]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "DEBUG", "message": "Session started [55]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "DEBUG", "message": "Session started [55]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "User logged in [56]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "User logged in [56]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "JWT expired [57]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "JWT expired [57]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "WARN", "message": "Stock unavailable [58]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "WARN", "message": "Stock unavailable [58]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "WARN", "message": "Report generation started [59]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "WARN", "message": "Report generation started [59]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "Stripe timeout [60]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "Stripe timeout [60]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "DEBUG", "message": "Stock updated [61]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "DEBUG", "message": "Stock updated [61]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "Inventory sync failed [62]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "Inventory sync failed [62]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "ERROR", "message": "User logged out [63]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "ERROR", "message": "User logged out [63]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "User logged in [64]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "User logged in [64]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Event processing delay detected [65]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Event processing delay detected [65]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Session started [66]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Session started [66]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Payment successful [67]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Payment successful [67]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Stock unavailable [68]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Stock unavailable [68]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "INFO", "message": "Login attempt with deprecated token [69]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "INFO", "message": "Login attempt with deprecated token [69]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Payment successful [70]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Payment successful [70]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "Payment successful [71]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "Payment successful [71]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "WARN", "message": "Stock unavailable [72]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "WARN", "message": "Stock unavailable [72]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Unusual payment pattern detected [73]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Unusual payment pattern detected [73]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "DEBUG", "message": "SMS failed [74]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "DEBUG", "message": "SMS failed [74]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "User logged in [75]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "User logged in [75]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "DEBUG", "message": "Session started [76]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "DEBUG", "message": "Session started [76]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "DEBUG", "message": "Email sent [77]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "DEBUG", "message": "Email sent [77]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "ERROR", "message": "Login attempt with deprecated token [78]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "ERROR", "message": "Login attempt with deprecated token [78]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "JWT expired [79]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "JWT expired [79]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "Payment successful [80]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "Payment successful [80]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "DEBUG", "message": "Session started [81]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "DEBUG", "message": "Session started [81]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "Inventory sync failed [82]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "Inventory sync failed [82]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "INFO", "message": "JWT expired [83]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "INFO", "message": "JWT expired [83]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "DEBUG", "message": "Inventory sync failed [84]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "DEBUG", "message": "Inventory sync failed [84]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "Login attempt with deprecated token [85]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "Login attempt with deprecated token [85]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Unusual payment pattern detected [86]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Unusual payment pattern detected [86]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "WARN", "message": "Payment successful [87]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "WARN", "message": "Payment successful [87]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "INFO", "message": "Unusual payment pattern detected [88]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "INFO", "message": "Unusual payment pattern detected [88]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "JWT expired [89]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "JWT expired [89]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "Login attempt with deprecated token [90]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "Login attempt with deprecated token [90]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "INFO", "message": "Stock updated [91]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "INFO", "message": "Stock updated [91]"}'
echo ""
echo "Posting: {"service": "notification-service", "level": "INFO", "message": "Inventory sync failed [92]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "notification-service", "level": "INFO", "message": "Inventory sync failed [92]"}'
echo ""
echo "Posting: {"service": "auth-service", "level": "WARN", "message": "Event processing delay detected [93]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "auth-service", "level": "WARN", "message": "Event processing delay detected [93]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "Session started [94]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "Session started [94]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "User logged out [95]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "User logged out [95]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "DEBUG", "message": "SMS failed [96]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "DEBUG", "message": "SMS failed [96]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Stock updated [97]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Stock updated [97]"}'
echo ""
echo "Posting: {"service": "inventory-service", "level": "ERROR", "message": "Stock unavailable [98]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "inventory-service", "level": "ERROR", "message": "Stock unavailable [98]"}'
echo ""
echo "Posting: {"service": "analytics-service", "level": "ERROR", "message": "User logged out [99]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "analytics-service", "level": "ERROR", "message": "User logged out [99]"}'
echo ""
echo "Posting: {"service": "payment-service", "level": "ERROR", "message": "Payment failed [100]"}"
curl -s -X POST "$ENDPOINT" -H "Content-Type: application/json" -d '{"service": "payment-service", "level": "ERROR", "message": "Payment failed [100]"}'
echo ""
echo "Log seeding complete!"
