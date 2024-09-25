Feature: Reusable function
@getExample3
Scenario: verify current whether data reusability
Then def JavaDemo = Java.type('com.karate.runner.Reader.class')
#Then def JavaDemo = call read('classpath:com/karate/runner/Reader.java')
Then def value = JaveDemo.loginMessage()
Then print value

@postExample23
Scenario: verify dummy sample rest api post request
Given url envURL + "/api/v1/create"
And request {"name":"test","salary":"123","age":"23"}
When method post
Then status 200

