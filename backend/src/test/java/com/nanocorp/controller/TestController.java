package com.nanocorp.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.WebResource.Builder;

/**
 * Test client
 */
public class TestController {

	/**
	 * App base url.
	 */
	private static final String BASE_URL = "http://localhost:8090";

	/**
	 * Valid user name.
	 */
	private static final String VALID_USER_NAME = "test";

	/**
	 * Valid user password.
	 */
	private static final String VALID_USER_PASSWORD = "test";

	/**
	 * Test that valid user can log in.
	 */
	@Test
	public void testValidUserLoginOk() {
		String token = executeLogin(VALID_USER_NAME, VALID_USER_PASSWORD);
		Assert.assertNotNull(token);
	}

	/**
	 * Test that wrong user cannot log in.
	 */
	@Test(expected = RuntimeException.class)
	public void testWrongUserLoginKo() {
		executeLogin("unknown", VALID_USER_PASSWORD);
	}

	/**
	 * Test that a not logged in user cannot access to REST method
	 */
	@Test(expected = RuntimeException.class)
	public void testNotLoggedInAccess() {
		getCampaigns(null);
	}

	/**
	 * Test that a logged in user can access to campaigns method
	 */
	@Test
	public void testLoggedUserCanAccess() {
		String token = executeLogin(VALID_USER_NAME, VALID_USER_PASSWORD);
		getCampaigns(token);
	}

	/**
	 * Execute login REST call
	 *
	 * @param username
	 *        user name
	 * @param password
	 *        user password
	 * @return server token
	 * @throws RuntimeException
	 *         exception
	 */
	private String executeLogin(String username, String password) throws RuntimeException {
		Client client = Client.create();

		WebResource webResource = client.resource(BASE_URL + "/login?username=" + username + "&password=" + password);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String token = response.getHeaders().get("Authorization").get(0);
		return token;
	}

	/**
	 * Execute campaigns REST method
	 *
	 * @param token
	 *        JWS token
	 * @return the value from the method
	 * @throws RuntimeException
	 *         exception
	 */
	private String getCampaigns(String token) throws RuntimeException {
		Client client = Client.create();

		Builder builder = client.resource(BASE_URL + "/campaign").header(HttpHeaders.AUTHORIZATION, token);
		ClientResponse response = builder.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		return output;
	}

}
