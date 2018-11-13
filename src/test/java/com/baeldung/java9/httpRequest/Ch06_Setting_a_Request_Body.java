package com.baeldung.java9.httpRequest;

import jdk.incubator.http.HttpRequest;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch06_Setting_a_Request_Body {


	@Test
	public void test() throws URISyntaxException {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/post"))
			.POST(HttpRequest.BodyPublisher.noBody())
			.build();
	}


}
