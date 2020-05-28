package com.upchain.arch.cucumberdemo.bdd.stepdefs;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.upchain.arch.cucumberdemo.bdd.HeaderSettingRequestCallback;
import com.upchain.arch.cucumberdemo.bdd.ResponseResults;
import com.upchain.arch.cucumberdemo.controller.HelloController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SaysHello {

    @Autowired
    private HelloController helloController;

    public static ResponseResults latestResponse = null;

    protected RestTemplate restTemplate = new RestTemplate();

    public void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }

    @When("^the client calls /hello$")
    public void the_client_calls_sayHello() throws Throwable{
        executeGet("http://localhost:8080/hello");
    }

    @When("^the client calls /version")
    public void the_client_calls_getVersion() throws Throwable{
        executeGet("http://localhost:8080/version");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : ", currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives response of .*")
    public void the_client_receives_response_of() throws Throwable {
        assertThat("response is incorrect : ", latestResponse.getBody(), is(helloController.sayHello()));
    }

    @And("^the client receives version .*")
    public void the_client_receives_version() throws Throwable {
        assertThat("version is incorrect : ", latestResponse.getBody(), is(helloController.getVersion()));
    }

    private class ResponseResultErrorHandler implements ResponseErrorHandler {
        private ResponseResults results = null;
        private Boolean hadError = false;

        private ResponseResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new ResponseResults(response);
        }
    }

}

