package com.baeldung.java9.httpRequest;

import jdk.incubator.http.HttpRequest;
import org.junit.Test;

import java.net.URI;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch04_Setting_Headers {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.headers("key1", "value1", "key2", "value2")
			.GET()
			.build();
	}


	@Test
	public void test2() throws Exception {
		HttpRequest request2 = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.header("key1", "value1")
			.header("key2", "value2")
			.GET()
			.build();
	}


}
