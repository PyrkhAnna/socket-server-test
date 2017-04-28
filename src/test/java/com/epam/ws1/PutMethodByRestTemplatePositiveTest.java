package com.epam.ws1;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutMethodByRestTemplatePositiveTest {
	
	@Test(priority = 1)
	public void putMethodBookXML() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book/3.xml";
		String body ="<?xml version='1.0' encoding='UTF-8' standalone='yes'?><book><author>Carl</author><id>4</id></book>";
		RequestEntity<String> requestEntity =RequestEntity.put(new URI(bookResourceUrl)).accept(MediaType.TEXT_HTML).body(body);
		ResponseEntity<String> response= restTemplate.exchange(requestEntity, String.class);
		Assert.assertEquals(true, response.getStatusCode().is2xxSuccessful()||response.getStatusCode().is3xxRedirection());
	}
}
