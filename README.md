# Esp8266-motion-notifier

Notifier service for the Arduino Smart House project.

## Table of contents

-   [Brief Description](#brief-description)
-   [Built In - Technologies](#built-in---technologies)
-   [Libraries References](#libraries-references)

## Brief Description

Back in 2023, I used to work on a smart house sample built with Arduino modules (you can see some photos of the finished project on my [LinkedIn](https://www.linkedin.com/in/marco-facecchia-93362b2b2/details/projects), btw). One of the project's main components involved a motion sensor linked with an Arduino Mega, which communicated with an ESP8266 used to make a request to an IFTTT endpoint to warn the house owner via email about the motion detected (pretty cool, huh?). Anyways, back at that time, the service IFTTT provided was free of charge, and everything worked just fine, but after some time, they decided to make the same service paid. That's when it came to my mind how simple that functionality was, and so I decided to write my own implementation of the same.\
This Java/Javalin project is then basically the same implementation they used to provide for free, but entirely written by myself, to make my ESP8266 useful again.

## Built In - Technologies

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## Libraries References

-   [Javalin](https://javalin.io)
-   [Dotenv](https://github.com/cdimascio/dotenv-java)
