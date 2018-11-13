package com.baeldung.java9.httpRequest;

import jdk.incubator.http.HttpRequest;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Paths;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch10_FileProcessor {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/post"))
			.headers("Content-Type", "text/plain;charset=UTF-8")
			.POST(HttpRequest.BodyPublisher.fromFile(
				Paths.get("src/test/resources/sample.txt")))
			.build();
	}
}
