FROM eclipse-temurin:21-alpine

ARG APP_NAME=ESP8266-Notifier-1.0.jar

WORKDIR /app
COPY target/${APP_NAME} /app

# TODO: Add project's environmental variables (probably via docker compose)

EXPOSE 8000

CMD ["java", "-jar", ${APP_NAME}]