FROM eclipse-temurin:21-alpine

ARG APP_NAME=ESP8266-Notifier-1.0.jar
ENV APP_NAME=${APP_NAME}

WORKDIR /app
COPY target/${APP_NAME} /app

EXPOSE 8000

ENTRYPOINT java -jar ${APP_NAME}