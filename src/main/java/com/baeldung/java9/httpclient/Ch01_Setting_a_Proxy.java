package com.baeldung.java9.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.net.ProxySelector;
import java.net.URI;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch01_Setting_a_Proxy {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.GET()
			.build();

		HttpResponse<String> response = HttpClient
			.newBuilder()
			.proxy(ProxySelector.getDefault())
			.build()
			.send(request, HttpResponse.BodyHandler.asString());
	}


}
