package com.upchain.arch.cucumberdemo.bdd.stepdefs;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.upchain.arch.cucumberdemo.bdd.CucumberTestContextConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;


public class SayHello extends CucumberTestContextConfiguration {
    @When("^the client calls /hello$")
    public void the_client_issues_GET_version() throws Throwable{
        executeGet("http://localhost:8080/hello");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : "+
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives Hello$")
    public void the_client_receives_hello_back(String helloText) throws Throwable {
        assertThat(latestResponse.getBody(), is(helloText));
    }
}
