package com.atf.restassured.implementations;

import java.io.File;
import java.util.Map;

import com.atf.restassured.GlobalVariables;
import com.atf.restassured.utils.ApiUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class RequestBuilderImpl extends ApiUtils {

	public static RequestSpecification reqspec = RestAssured.given();

	public void buildURL(String uri, String url, String queryparams) {
		reqspec.baseUri(uri).basePath(url);
		if (!queryparams.trim().equals("")) {
			reqspec.queryParams(asMap(queryparams));
		}
	}

	public void addHeaders(String filename, String key) {
		String file_path = GlobalVariables.headers_path + filename + ".json";
		JsonPath json = JsonPath.from(new File(file_path));
		Map<String, String> headers = json.get(key);
		reqspec.headers(headers);
	}

	public void addPayload(String filename) {
		String file_path = GlobalVariables.payload_path + filename + ".json";
		reqspec.body(new File(file_path));
	}

}
