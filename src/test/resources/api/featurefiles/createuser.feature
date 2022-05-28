# Author 		: automationtest.dev@gmail.com
# LinkedIn 	: https://www.linkedin.com/in/test-automation-development-bbb664239/
# GitHub		: https://github.com/ta2dev
# Docker		: https://hub.docker.com/u/ta2dev
#
@users
Feature: verify rest api create(post) service using cucumber

  @createuser @regression
  Scenario Outline: verify create user api
    Given Build URL using "<baseURL>" and "<urlPATH>" and "<queryParameters>"
    And Add headers "<headers>" to the request
    And Add payload "<paylod>" to the request
    When Send the request using "<method>" method
    Then Verify Service return "<statusCode>" status code
    And Verify Service return "<responseValidations>"

    Examples: 
      | description                     | baseURL           | urlPATH    | queryParameters | headers                   | method | paylod                 | statusCode | responseValidations |
      | create user using valid payload | https://reqres.in | /api/users |                 | getusers_headers,positive | POST   | create_user/createuser |        201 | name=morpheus       |
