# Author 		: automationtest.dev@gmail.com
# LinkedIn 	: https://www.linkedin.com/in/test-automation-development-bbb664239/
# GitHub		: https://github.com/ta2dev
# Docker		: https://hub.docker.com/u/ta2dev
#

@users
Feature: verify rest api get users(get) service using cucumber

	@getuser @smoke @regression
  Scenario Outline: verify get users api
    Given Build URL using "<baseURL>" and "<urlPATH>" and "<queryParameters>"
    And Add headers "<headers>" to the request
    When Send the request using "<method>" method
    Then Verify Service return "<statusCode>" status code
    And Verify Service return "<responseValidations>"

    Examples: 
      | description                                       | baseURL           | urlPATH       | queryParameters | headers                   | method | statusCode | responseValidations |
      | get user using query params of page 2             | https://reqres.in | /api/users    | page=2          | getusers_headers,positive | GET    |        200 | per_page=6          |
      | get user using id in the url path                 | https://reqres.in | /api/users/2  |                 | getusers_headers,positive | GET    |        200 | data.id=2           |
      | get user who is not list return 404 response code | https://reqres.in | /api/users/23 |                 | getusers_headers,positive | GET    |        404 |                     |