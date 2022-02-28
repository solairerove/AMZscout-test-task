# Env
```shell
➜  AMZscout-test-task git:(master) java -version
openjdk version "11.0.13" 2021-10-19 LTS
OpenJDK Runtime Environment Zulu11.52+13-CA (build 11.0.13+8-LTS)
OpenJDK 64-Bit Server VM Zulu11.52+13-CA (build 11.0.13+8-LTS, mixed mode)

➜  AMZscout-test-task git:(master) ✗ mvn -v
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /Users/nikita.krivitsky/.sdkman/candidates/maven/current
Java version: 11.0.13, vendor: Azul Systems, Inc., runtime: /Users/nikita.krivitsky/.sdkman/candidates/java/11.0.13-zulu/zulu-11.jdk/Contents/Home
Default locale: en_RU, platform encoding: UTF-8
OS name: "mac os x", version: "11.6", arch: "aarch64", family: "mac"
```

# Build
```shell
mvn clean install && java -jar target/amzscout-test-task-0.0.1-SNAPSHOT.jar
```

# Docker build
```shell
docker build -t limiter .
docker run -dp 8080:8080 limiter:latest
docker logs -f container_name
```

# Endpoints
http://localhost:8080/api/v1/hello
http://localhost:8080/api/v1/limitation

# Notes
- не использовал градл, потому что презираю его. но если он есть на проекте я ок
- почему не джава, потому что воспользовался правилом "Возможны другие вспомогательные библиотеки."
- почему не жэюнит, потому что пункт 2
- 