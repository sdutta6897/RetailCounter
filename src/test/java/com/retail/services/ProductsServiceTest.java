package com.retail.services;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.retail.exceptions.ErrorCodes;
import com.retail.exceptions.RetailException;

public class ProductsServiceTest {

	ProductsService productService = ProductsService.getInstance();

	@Test
	public void test_loadProducts_whenSuccess() {
		try {
			productService.loadProducts();
		} catch (RetailException e) {
			fail(e.getErrorCode().getDescription());
		}
	}

	@Test(expected = RetailException.class)
	public void test_loadProducts_whenFailure() throws RetailException {
		ProductsService productsServiceMock = Mockito.mock(ProductsService.class);
		Mockito.doThrow(new RetailException(ErrorCodes.ERR_PRODUCT_DATA_LOAD_ERROR)).when(productsServiceMock)
				.loadProducts();
		productsServiceMock.loadProducts();
	}

	@Test
	public void test_getProduct_whenFound() {
		try {
			productService.loadProducts();
		} catch (RetailException e) {
			fail(e.getErrorCode().getDescription());
		}
		try {
			Assert.assertNotNull(productService.getProductDetails("1"));
		} catch (RetailException e) {
			fail(e.getErrorCode().getDescription());
		}
	}

}
