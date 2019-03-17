package com.retail.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.retail.exceptions.RetailException;
import com.retail.view.model.ReceiptDetails;

/**
 * The class will test the receipt service
 * 
 *
 */
public class ReceiptServiceTest {

	private static ProductsService productsService = ProductsService.getInstance();

	@BeforeClass
	public static void loadData() throws RetailException {
		productsService.loadProducts();
	}

	@Test
	public void testCalculateReceipt_when_ValidValue_thenReturnReceipt() {

		ReceiptService receiptService = new ReceiptService();
		ReceiptDetails receiptDetails = receiptService.calculateReceipt(Arrays.asList("1", "2"));
		assertNotNull(receiptDetails);
		assertNotNull(receiptDetails.getProductDetails());
		assertTrue(receiptDetails.getProductDetails().size() == 2);

	}

	@Test
	public void testCalculateReceipt_when_InValidValue_thenReturnReceipt() {
		ReceiptService receiptService = new ReceiptService();
		ReceiptDetails receiptDetails = receiptService.calculateReceipt(Arrays.asList("6", "7"));
		assertNotNull(receiptDetails);
		assertFalse(receiptDetails.isGenerationSuccessfulIndicator());
	}

}
