@parallel=false
Feature: validate get request

@getExample1
Scenario: verify current whether data
Given url 'http://api.openweathermap.org/data/2.5/weather?q=London&appid=3c322ae59a7b42f9559ae5ef9c1d9ef9'
When method get
Then status 200
#And match response.weather[0].description !contains 'surendra Jaganadam'
And match response.weather[0].description != '#number'
#And def des = response.weather[0].description

@getExample2
Scenario Outline: verify current whether data
Given url '<url>'
When method get
Then status 200
And def decimal = response.weather[0].description
Then print des

Examples:
|url|
|http://api.openweathermap.org/data/2.5/weather?q=London&appid=3c322ae59a7b42f9559ae5ef9c1d9ef9|
#|http://api.openweathermap.org/data/2.5/weather?q=London&appid=3c322ae59a7b42f9559ae5ef9c1d9ef9|
#|http://api.openweathermap.org/data/2.5/weather?q=London&appid=3c322ae59a7b42f9559ae5ef9c1d9ef9|
