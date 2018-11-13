package com.baeldung.java9.httpRequest;

import jdk.incubator.http.HttpRequest;
import org.junit.Test;

import java.net.URI;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch05_Setting_a_Timeout {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.timeout(Duration.of(10, SECONDS))
			.GET()
			.build();
	}

}
