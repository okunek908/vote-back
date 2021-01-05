# vote-back
Voting back-end

## Build steps

To build locally, make sure you have following software installed:
* JavaSE SDK 15
* Maven 3 
* Docker (if you want to build image / run in the container)

Build:
1. Git clone or download the source code
2. Run `mvn clean install`
3. Run `docker build -t vote-backend .`

## Run Backend
1. Run application:
    * Running from terminal: 
    `java -jar vote-backend-1.0-SNAPSHOT.jar`
    * Running Docker:
   `docker run -it -p8080:8080 vote-backend`
      
2. Connect at URL: http://localhost:8080
3. Connect Swagger at: http://localhost:8080/swagger-docs

## Local Development Environment Configuration on MacOS

1. Install SDKMAN (https://sdkman.io/): 
   `curl -s "https://get.sdkman.io" | bash`
   `source "$HOME/.sdkman/bin/sdkman-init.sh"`
2. Install JAVA SE 15 SDK:
   `sdk install java 15.0.1-open`
3. Install Maven 3.6.3:
   `sdk install maven`
4. Install Micronaut CLI tools:
   `sdk install micronaut`