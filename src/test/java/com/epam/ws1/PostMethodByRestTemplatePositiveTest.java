package com.epam.ws1;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.ws1.bean.Book;

public class PostMethodByRestTemplatePositiveTest {
	@Test(priority = 1)
	public void postMethodBookXML() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		String bookResourceUrl = "http://localhost:8080/book/bookbase.xml";
		//String body ="<?xml version='1.0' encoding='UTF-8' standalone='yes'?><book><author>Carl</author><id>4</id></book>";
		Book book = new Book();
		MultiValueMap<String,String> requestHeaders = new HttpHeaders();
		HttpEntity<Book> request = new HttpEntity<Book>(book, requestHeaders);
		URI uriCreatedResource =restTemplate.postForLocation(bookResourceUrl, request, Book.class);
		Assert.assertEquals(true, uriCreatedResource.getPath().equalsIgnoreCase(bookResourceUrl));
	}
}
