package com.retail.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.retail.exceptions.RetailException;

public class ProductsServiceTest {

	ProductsService productService = ProductsService.getInstance();

	@Test
	public void test() {
		try {
			productService.loadProducts();
		} catch (RetailException e) {
			fail(e.getErrorCode().getDescription());
		}
	}

}
