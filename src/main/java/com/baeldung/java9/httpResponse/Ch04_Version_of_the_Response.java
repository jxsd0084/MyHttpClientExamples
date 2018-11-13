package com.baeldung.java9.httpResponse;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch04_Version_of_the_Response {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.version(HttpClient.Version.HTTP_2)
			.GET()
			.build();

		HttpResponse<String> response = HttpClient.newHttpClient()
			.send(request, HttpResponse.BodyHandler.asString());
		
		assertThat(response.version(), equalTo(HttpClient.Version.HTTP_1_1));
	}

}
