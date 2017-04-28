package com.epam.ws1;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMethodByRestTemplatePositiveTest {
	@Test(priority = 1)
	public void deleteMethodBookXML() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book?id=4";
		RequestEntity<Object> requestEntity =new RequestEntity<Object>(HttpMethod.DELETE, new URI(bookResourceUrl));
		ResponseEntity<String> response= restTemplate.exchange(requestEntity, String.class);
		Assert.assertEquals(true, response.getStatusCode().is2xxSuccessful());
	}
}
