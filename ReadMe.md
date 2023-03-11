# Weather-RestApi
This SpringBoot project uses **OpenWeather API** to receive city coordinates and current weather by city name.
After receiving the data, it makes a **record in database**, and you can **get the statistics of temperature by city name**.

In this project I learned how to **work with third party API's**, how to parse data from JSON to local entities 
and **implemented the DTO pattern**. This is also **my first SpringBoot** application.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/nikita-shamrai/weather-restapi.git
```

**2. Create Mysql database**
```bash
create database test
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation
+ make sure you use proper `spring.datasource.url` 

## How to Run

* Build the project by running `mvn clean package`
* Once successfully built, run the service by using the following command:
```
java -jar target/weather-api-v2-0.0.1-SNAPSHOT.jar
```
* Or using maven command:
```bash
mvn spring-boot:run
```
**The app will start running at <http://localhost:8080>**

## Explore Rest APIs

The app defines following GET APIs.

### Posts

| Method | Url                        | Description                                                                 | Response samples      |
| ------ |----------------------------|-----------------------------------------------------------------------------|-----------------------|
| GET    | /api/{city_name}           | Get weather for city                                                        | [JSON](#getweather)   ||
| GET    | /api/statistic/{city_name} | Get weather statistic for city (only works with previous data you recieved) | [JSON](#getstatistic) ||

## Response Samples

##### <a id="getweather">Get Current Weather -> /api/Kyiv</a>
```json
{
  "lat": 50.4500336,
  "lon": 30.5241361,
  "name": "Kyiv",
  "temperature": 7.41,
  "weatherStatus": "Clouds"
}
```

##### <a id="getstatistic">Get Statistic -> /api/statistic/Kyiv</a>
```json
{
  "name": "Kyiv",
  "lat": 50.4500336,
  "lon": 30.5241361,
  "weatherDTOList": [
    {
      "weatherStatus": "Clouds",
      "temperature": 7.41,
      "onTime": "2023-03-11 09:08:35"
    },
    {
      "weatherStatus": "Sunny",
      "temperature": 8.04,
      "onTime": "2023-03-11 12:20:20"
    },
    {
      "weatherStatus": "Rainy",
      "temperature": 3.55,
      "onTime": "2023-03-11 21:02:53"
    }
  ]
}
```
