# Maintain vehicle data

A very basic Maintain vehicle data application created with Java, Spring Boot, and Postgresql.

## Features Implemented:

1. Adding vehicle data into database.
2. Fetching vehicle data from database by using vehicle id.
3. Updating vehicle data.
4. Deleting vehicle data by vehicle id.

## Usage Guide

> *Importing and Running The Project Through IntelliJ IDEA*

**Step 1:** Click On File > Code > Copy Https URL > Open terminal > change directory where you want save > Paste The Repository Url as: https://github.com/vinayakkamati/maintain-vehicle-data.git > Enter.

**Step 2:** Open IntelliJ IDEA. [Install, if not already installed]

**Step 3:** Click on file > open > select file > Ok.

**Step 4:** Right click on SpringVotingSystemApplication file > Run.

**Step 5:** Check the Application is running At http://localhost:8080/

**Step 6:** Open postman, and please find the below URL's.

## Adding vehicle data:

> ### POST

 ***URL:*** ```localhost:8080/vehicle/cars```

>Request body

```
{
    "condition": "USED",
    "details": {
        "body": "sedan",
        "model": "Impala",
        "manufacturer": {
            "code": 101,
            "name": "Chevrolet"
        },
        "numberOfDoors": 4,
        "fuelType": "Gasoline",
        "engine": "3.6L V6",
        "mileage": 32280,
        "modelYear": 2018,
        "productionYear": 2018,
        "externalColor": "white"
    },
    "location": {
        "lat": 40.73061,
        "lon": -73.935242
    }
}
```
## Fetching vehicle data:

> ### GET

 ***URL:*** ```localhost:8080/vehicle/cars/{vehicleId}```
 
## Updating vehicle data:

> ### PUT

***URL:*** ```localhost:8080/vehicle/cars/{vehicleId}```
```
{
    "condition": "USED",
    "details": {
        "body": "sedan",
        "model": "Impala",
        "manufacturer": {
            "code": 101,
            "name": "Chevrolet"
        },
        "numberOfDoors": 4,
        "fuelType": "Gasoline",
        "engine": "3.6L V6",
        "mileage": 32280,
        "modelYear": 2018,
        "productionYear": 2018,
        "externalColor": "Black"
    },
    "location": {
        "lat": 40.73061,
        "lon": -73.935242
    }
}
```

# Deleting vehicle data:

> ### DELETE

 ***URL:*** ```localhost:8080/vehicle/cars/{vehicleId}```
