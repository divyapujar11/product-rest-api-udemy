package com.cg.springweb.productrestapi;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.springweb.productrestapi.entity.Product;
import com.cg.springweb.productrestapi.repository.ProductRepository;

class ProductRestControllerMockMvcTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ProductRepository repository;
	
	@Test
	public void testFindAll() {
		Product product = new Product();
		product.setId(1);
		product.setName("Mac");
		product.setDescription("Laptop");
		product.setPrice(1000);
//		List<Product> products = repository.sa
//		when(repository.findAll()).thenReturn(products);
	}

}
