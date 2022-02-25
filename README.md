# Getting Started

### Service description
Current service represents logic to generate randomly defined amount of IMEI numbers some of them invalid and some of them duplicates.
Service will validate IMEI numbers and will aggregate result to response JSON object also duplicated and valid values will be stared in the DB.

By the default service will start on port `8080` with few end point.

### APIs

1. Easy way to get result. Service will generate IMEIs and will validate automatically. Request needs one input parameter ``amount`` which represents initial amount of generated IMEIs.  
```
curl --location --request GET 'http://localhost:8080/imei?amount=23' \
--data-raw ''
```


2. Generate list of IMEIs with 20% of wrong and 20% of duplicates. Request needs one input parameter ``amount`` which represents initial amount of generated IMEIs.

```
curl --location --request GET 'http://localhost:8080/generate?amount=15' \
--data-raw ''
```


3. Run IMEI validation
```
curl --location --request POST 'http://localhost:8080/imei' \
--header 'Content-Type: application/json' \
--data-raw '{
    "input": []
}'

```

###To run service
```
./gradlew bootRun
```

##To Build service
```
./gradlew clean build
```

##Run tests
```
./gradlew test
```

###Project structure, packages:
- `controller` - web layer and end-point definition
- `data` - presentation and DB data objects
- `repository` - DB connection layer
- `service` - business logic  
- `utils` - validator and generator for IMEI


###Tech stack:
1. Java 11
2. Gradle
3. MongoDB
4. Lombok


