package com.baeldung.java9.httpClient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.net.URI;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch02_Setting_the_Redirect_Policy {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.version(HttpClient.Version.HTTP_2)
			.GET()
			.build();

		HttpResponse<String> response = HttpClient.newBuilder()
			.followRedirects(HttpClient.Redirect.ALWAYS)
			.build()
			.send(request, HttpResponse.BodyHandler.asString());
	}

	
}
