Feature: validate post request

@postExample
Scenario Outline: verify dummy sample rest api post request
Given configure retry = { count: 10, interval: 5000}
Given url '<url>'
And request {"name":"test","salary":"123","age":"23"}
When method post
And retry until response
Then status 200
#And def otherResponse = call read('classpath:features/Example1.feature')
#Then print otherResponse.des
#Then print otherResponse.decimal

Examples:
|url|
|http://dummy.restapiexample.com/api/v1/create|

@getExample4
Scenario Outline: verify dummy sample rest api post request
Given url '<url>'
When method get
Then status 200
And match each response.data ==
	"""
	{
	"id": "#number",
	"employee_name": "#string",
	"employee_salary": "#number",
	"employee_age": "#number",
	"profile_image": "##string"
	}
	
	"""

Examples:
|url|
|http://dummy.restapiexample.com/api/v1/employees|
