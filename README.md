# vote-back
Voting back-end application.

# Технологический Стек
## Развертывание
Для масштабируемости и удобства разработки рассматриваем 2 целевые платформы
* **Docker** / **Kubernetes Cluster**
* Serverless Cloud Platforms

Основным способом развертывания будет Docker. В проде возможно Кубер. Желательно проектировать с оглядкой на возможный деплоймент в Клауд (AWS или GCP) для минимизации затрат на поддержку инфраструктуры.

## API
* **REST + Swagger / OpenAPI** - де-факто стандарт, берем
* **GraphQL** - не нужен, тк нет сложных запросов

## Фреймворки
* **_Micronaut_** - похож на Spring, но легковеснее: прокси генерируются не в рантайме, а compile time - приложение стартует быстрее, магии меньше.
  Есть интеграции со всеми технологиями которые нам могут пригодится. Берем.
* **Spring Boot** - де-факто стандарт, много готовых интеграций - берем для более сложный кейзов, либо если микронавт разочарует.
* **Javalin** - сверхлегкий / простой / сверхбыстрый, но нет DI, отбросил.
* **Vert.x** - реактивный  (хорошая масштабируемость, но нам не особо надо)
* **Lagom** (Akka based) - реактивный, actor based (круто, но тоже не особо надо)

## База Данных
* Классической реляцонки - достаточно. Берем **Postgresql** как наиболее надежную и широко используемую.
* В NoSQL - пока не видно необходимости.

# Local Dev Environment Configuration (MacOS)

## Установить софт:
1. SDKMAN (https://sdkman.io/):
   `curl -s "https://get.sdkman.io" | bash`
   `source "$HOME/.sdkman/bin/sdkman-init.sh"`
2. JAVA SE 11 SDK:
   `sdk install java 11.0.10.hs-adpt`
3. Maven 3.6.3:
   `sdk install maven`
4. Docker https://docs.docker.com/get-docker/

5. (Optional) IntelliJ Idea либо другая IDE.
   
6. (Optional) Micronaut CLI tools:
   `sdk install micronaut`

## Build steps

1. Git clone (or download the source code from GitHub).
2. Run `mvn clean install`
3. Run `docker build -t vote-backend .`

## Run Backend Locally
You can run backend against any Postgres database. Edit **application.yml** accordingly.

1. Build Postgresql DB image in folder docker-for-db:
   `docker build -t mypostgres .`
   
2. Run Postgres in Docker:
   `docker run -d -p5432:5432 mypostgres`
   
3. Run application either from IDE (run VoteApplication class) or in Docker:
   `docker run -it -p8080:8080 --net="host' vote-backend`
      
4. Connect at URL: http://localhost:8080
   * To monitor health status: http://localhost:8080/m/health
   * To get bean context info: http://localhost:8080/m/info
   * To verify DB migration: http://localhost:8080/m/flyway
   * Swagger: http://localhost:8080/swagger/vote-1.0.yml
   * Swagger UI: http://localhost:8080/swagger-ui/index.html


# Running on GCP

**Please ask me to provide access**
* Project 
  * name: Vote
  * project id: vote-301515
  * organization: okunook.com 
  * region: europe-west4
* Cloud Build CI (view access required): https://console.cloud.google.com/cloud-build/builds?authuser=1&orgonly=true&project=vote-301515
* Last built Docker image here (public): https://console.cloud.google.com/gcr/images/vote-301515/GLOBAL/vote-backend?project=vote-301515
* To deploy to Cloud Run (editor acces required): https://console.cloud.google.com/run?authuser=0&orgonly=true&project=vote-301515


