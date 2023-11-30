package com.woodwing.distance.calculator;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DistanceCalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DistanceCalculatorApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testEmptyBodyRequest() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/wing/v1/distance"),
				HttpMethod.GET, entity, String.class);

		String expected = "400";

		AssertionErrors.assertEquals("empty body", expected, response.getStatusCode().value() + "");
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
