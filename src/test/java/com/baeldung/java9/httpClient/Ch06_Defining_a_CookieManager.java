package com.baeldung.java9.httpClient;

import jdk.incubator.http.HttpClient;
import org.junit.Test;

import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * @author jakeChen
 * @Description: Exploring the New HTTP Client in Java 9
 * @URL: https://www.baeldung.com/java-9-http-client
 * @date 13/11/2018
 */
public class Ch06_Defining_a_CookieManager {


	@Test
	public void test() {
		HttpClient httpClient = HttpClient.newBuilder()
				                   .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
				                   .build();
	}


	@Test
	public void test2() {

	}
	
}
