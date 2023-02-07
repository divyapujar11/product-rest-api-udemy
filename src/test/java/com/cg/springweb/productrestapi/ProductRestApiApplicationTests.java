package com.cg.springweb.productrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.springweb.productrestapi.entity.Product;
import static org.junit.Assert.*;
@SpringBootTest
class ProductRestApiApplicationTests {
	
	@Value("${productapi.services.url}")
	private String baseUrl;

	@Test
	public void testGetProducts() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung Mobile");
		product.setDescription("Its Awesome");
		product.setPrice(1000);
		Product newProduct = restTemplate.postForObject(baseUrl, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Mobile", newProduct.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		product.setPrice(1400);
		restTemplate.put(baseUrl, product);
	}

}
