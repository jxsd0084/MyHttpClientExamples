package com.baeldung.java9.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch05_Setting_Executor_for_Asynchronous_Calls {


	ExecutorService executorService = Executors.newFixedThreadPool(2);


	@Test
	public void test() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("https://postman-echo.com/get"))
			.version(HttpClient.Version.HTTP_2)
			.GET()
			.build();

		CompletableFuture<HttpResponse<String>> response1 = HttpClient.newBuilder()
			.executor(executorService)
			.build()
			.sendAsync(request, HttpResponse.BodyHandler.asString());

		CompletableFuture<HttpResponse<String>> response2 = HttpClient.newBuilder()
			.executor(executorService)
			.build()
			.sendAsync(request, HttpResponse.BodyHandler.asString());
	}

	
}
