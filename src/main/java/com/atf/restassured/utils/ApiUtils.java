package com.atf.restassured.utils;

import java.util.Map;

import com.google.common.base.Splitter;

public class ApiUtils {

	public Map<String, String> asMap(String in) {
		return Splitter.on(",").withKeyValueSeparator("=").split(in);
	}
}
