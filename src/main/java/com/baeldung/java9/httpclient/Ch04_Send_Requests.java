package com.baeldung.java9.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch04_Send_Requests {


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.version(HttpClient.Version.HTTP_2)
			.GET()
			.build();

		HttpResponse<String> response = HttpClient.newBuilder()
			.build()
			.send(request, HttpResponse.BodyHandler.asString());
	}


	@Test
	public void test2() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.version(HttpClient.Version.HTTP_2)
			.GET()
			.build();

		CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
			.build()
			.sendAsync(request, HttpResponse.BodyHandler.asString());
	}


	@Test
	public void test3() throws Exception {
		List<URI> targets = Arrays.asList(
				new URI("https://postman-echo.com/get?foo1=bar1"),
				new URI("https://postman-echo.com/get?foo2=bar2"));

		HttpClient client = HttpClient.newHttpClient();
		List<CompletableFuture<String>> futures = targets.stream()
			.map(target -> client
				.sendAsync(
					HttpRequest.newBuilder(target).GET().build(),
					HttpResponse.BodyHandler.asString())
				.thenApply(response -> response.body()))
			.collect(toList());
	}


}
