package com.epam.ws1;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.ws1.bean.Book;

public class GetMethodByRestTemplatePositiveTest {
	
	@Test(priority = 1)
	public void getMethodAllBooks(){
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book";
		//HttpHeaders headers  = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_XML);
		//HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		//String body = "";
		//MultiValueMap<String,String> requestHeaders = null;
		//		 RequestEntity<String> request = new RequestEntity<String>(requestHeaders, HttpMethod.GET,new URI(bookResourceUrl));//.accept(MediaType.APPLICATION_XML);
		//ResponseEntity<String> response = restTemplate.exchange(bookResourceUrl, HttpMethod.GET, entity, String.class);
		
		ResponseEntity<String> response = restTemplate.getForEntity(bookResourceUrl, String.class);
		int statusCode = response.getStatusCodeValue();
		HttpStatus statusCodeEntity = response.getStatusCode();
		/*statusCodeEntity.value();
		statusCodeEntity.getReasonPhrase();
		statusCodeEntity.is1xxInformational();
		statusCodeEntity.is2xxSuccessful();
		statusCodeEntity.is3xxRedirection();
		statusCodeEntity.is4xxClientError();
		statusCodeEntity.is5xxServerError();
		HttpHeaders headers = response.getHeaders();
		List<String> headersValue = headers.get("HEADER_NAME");
		headers.getContentType();
		headers.getContentLength();
		headers.getLocation();
		String rpBody = response.getBody();
		response.hasBody();*/
		Assert.assertEquals(true, statusCode==200);
		Assert.assertEquals(true, statusCodeEntity.is2xxSuccessful());
	}
	@Test(priority = 2)
	public void getMethodBook(){
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book?id=1";
		Book requestedBook = restTemplate.getForObject(bookResourceUrl, Book.class);
		Assert.assertNotNull(requestedBook);
	}
	@Test(priority = 3)
	public void getMethodBookXML(){
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book?id=1";
		ResponseEntity<String> response = restTemplate.getForEntity(bookResourceUrl, String.class);
		HttpHeaders headers = response.getHeaders();
		Assert.assertEquals(true, response.getStatusCode().is2xxSuccessful());
		Assert.assertEquals(true, headers.getContentType().equals(MediaType.APPLICATION_XML));
	}
	/*
	@Test(priority = 4)
	public void getMethodBookJSON(){
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book?id=1";
		ResponseEntity<String> response = restTemplate.getForEntity(bookResourceUrl, String.class);
		HttpHeaders headers = response.getHeaders();
		Assert.assertEquals(true, response.getStatusCode().is2xxSuccessful());
		Assert.assertEquals(true, headers.getContentType().equals(MediaType.APPLICATION_XML));
	}*/
}
