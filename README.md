# distance_calculator
REST API service to calculate distance

# Prerequisite to run this:
1. The machine running this program need the below:
   2. java 21
   3. Apache Maven 3.9.4


# This program can be started using the 2 below approch:
## 1. From the project directory:
    mvn spring-boot:run

## 2. Running the jar(This requires the program compiled):
    java -jar target\distrance_calculator-0.0.1-SNAPSHOT.jar


## REST API:
## 1. Get distance:
#### GET: http://localhost:8084/wing/v1/distance
#### sample request body:
      {
         "pointA": {
            "distance": 10.0,
            "unit": "METER"
         },
            "pointB": {
            "distance": 20.0,
            "unit": "yard"
         },
         "responseDistanceUnit": "METER"
      }

#### sample Response body:
      28.288 METER