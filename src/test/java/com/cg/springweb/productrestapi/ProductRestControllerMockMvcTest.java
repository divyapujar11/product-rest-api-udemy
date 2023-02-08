package com.cg.springweb.productrestapi;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.cg.springweb.productrestapi.controller.ProductRestController;
import com.cg.springweb.productrestapi.entity.Product;
import com.cg.springweb.productrestapi.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@WebMvcTest
class ProductRestControllerMockMvcTest {

	private static final String PRODUCT_URL = "/products/";


	private static final int PRODUCT_PRICE = 1000;


	private static final String PRODUCT_DESCRIPTION = "Laptop";


	private static final String PRODUCT_NAME = "Mac";


	private static final int PRODUCT_ID = 1;


	@Autowired
	private MockMvc mockmvc;
	
	
	@MockBean
	private ProductRepository repository;
	
	@Test
	public void testFindAll() throws Exception {
		Product product = buildProduct();
		
		List<Product> products = Arrays.asList(product);
		when(repository.findAll()).thenReturn(products);
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockmvc.perform(get(PRODUCT_URL).contextPath(PRODUCT_URL)).andExpect(status().isOk())
//		.andExpect(content().json("[{'id':1,'name':'Mac','description':'Laptop','price':1000}]"));
		.andExpect(objectWriter.writeValueAsString(products));
		
		
	}

	private Product buildProduct() {
		Product product = new Product();
		product.setId(PRODUCT_ID);
		product.setName(PRODUCT_NAME);
		product.setDescription(PRODUCT_DESCRIPTION);
		product.setPrice(PRODUCT_PRICE);
		return product;
	}

}
