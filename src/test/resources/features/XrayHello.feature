@XRT-222
Feature: Cucumber Demo Feature: Says Hello

	#*  This test is to demo Xray integration with Cucumber tests for a Spring boot project
  @TEST_XRT-221
  Scenario: Hello Cucumber Demo Scenario
    When the client calls /hello
    Then the client receives status code of 200
    And the client receives response of Hello from Cucumber!