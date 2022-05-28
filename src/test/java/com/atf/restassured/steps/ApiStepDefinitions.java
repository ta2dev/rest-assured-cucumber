package com.atf.restassured.steps;

import com.atf.restassured.implementations.RequestBuilderImpl;
import com.atf.restassured.implementations.ResponseExtractImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDefinitions {

	RequestBuilderImpl req = new RequestBuilderImpl();
	ResponseExtractImpl res = new ResponseExtractImpl();

	@Given("Build URL using {string} and {string} and {string}")
	public void build_url_using_and_and(String string, String string2, String string3) {
		req.buildURL(string, string2, string3);
	}	
	
	@Given("Add headers {string} to the request")
	public void add_headers_to_the_request(String string) {
		String[] header = string.split(",");
		req.addHeaders(header[0], header[1]);
	}

	@Given("Add payload {string} to the request")
	public void add_payload_to_the_request(String string) {
		req.addPayload(string);
	}


	@When("Send the request using {string} method")
	public void send_the_request_using_method(String string) {
		res.send_request(string);
	}

	@Then("Verify Service return {string} status code")
	public void verify_service_return_status_code(String string) {
		res.verify_status_code(string);
	}

	@Then("Verify Service return {string}")
	public void verify_service_return(String string) {
		res.validate_response_data(string);
	}
}
