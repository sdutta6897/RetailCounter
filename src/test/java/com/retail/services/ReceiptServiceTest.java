package com.retail.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.retail.view.model.ReceiptDetails;

/**
 * The class will test the receipt service
 * 
 *
 */
public class ReceiptServiceTest {

	@Test
	public void testCalculateReceipt() {
		ReceiptService receiptService = new ReceiptService();
		ReceiptDetails receiptDetails = receiptService.calculateReceipt(Arrays.asList("1", "2"));
		assertNotNull(receiptDetails);
		assertNotNull(receiptDetails.getProductDetails());
		assertTrue(receiptDetails.getProductDetails().size() == 2);

	}

}
