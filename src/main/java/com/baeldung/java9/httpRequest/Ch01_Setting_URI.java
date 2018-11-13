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
public class Ch01_Setting_URI {


	// TODO Setting URI

	@Test
	public void test() throws Exception {
		HttpRequest.Builder builder = HttpRequest.newBuilder(new URI("https://postman-echo.com/get"));
	}


	@Test
	public void test2() throws Exception {
		HttpRequest.Builder builder = HttpRequest.newBuilder()
				                          .uri(new URI("https://postman-echo.com/get"));
	}


}
