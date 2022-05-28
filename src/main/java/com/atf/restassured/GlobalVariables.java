package com.atf.restassured;

import java.io.File;

public class GlobalVariables {

	public static final String src_api_path = "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator + "api" + File.separator;

	public static final String headers_path = src_api_path + "headers" + File.separator;
	public static final String payload_path = src_api_path + "payload" + File.separator;
	public static final String validations_path = src_api_path + "validations" + File.separator;

}
