package com.atf.restassured.implementations;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import io.restassured.response.Response;

public class ResponseExtractImpl extends RequestBuilderImpl {

	public Response response;

	private Response getResponse() {
		return response;
	}

	private void setResponse(Response response) {
		this.response = response;
	}

	public void send_request(String method) {
		if (method.equalsIgnoreCase("get")) {
			Response res = reqspec.when().log().all(true).get().then().log().all(true).extract().response();
			setResponse(res);
		}

		if (method.equalsIgnoreCase("post")) {
			Response res = reqspec.when().log().all(true).post().then().log().all(true).extract().response();
			setResponse(res);
		}
	}

	public void verify_status_code(String statuscode) {
		assertEquals(statuscode, String.valueOf(getResponse().statusCode()));
	}

	public void validate_response_data(String str) {
		if (!str.trim().equals("")) {
			Map<String, String> keys = asMap(str);
			for (String key : keys.keySet()) {
				String expected_value = keys.get(key);
				String actual_value = getResponse().jsonPath().get(key).toString();
				assertEquals(expected_value, actual_value);
			}
		}
	}
}
