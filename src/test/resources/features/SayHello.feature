Feature: Says Hello
  Scenario: client makes call to GET /hello
    When the client calls /hello
    Then the client receives status code of 200
