package com.retail.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.exceptions.RetailException;
import com.retail.services.ProductsService;
import com.retail.services.ReceiptService;
import com.retail.view.model.ReceiptDetails;

public class ReceiptEngine {
	private static final Logger logger = LoggerFactory.getLogger(ReceiptEngine.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> barCodes = new ArrayList<>();
		ProductsService productsService = ProductsService.getInstance();
		ReceiptService receiptService = new ReceiptService();
		try {
			productsService.loadProducts();
			System.out.println("Enter number of products : ");
			int numberOfProducts = scanner.nextInt();
			IntConsumer intConsumer = expression -> {
				System.out.println("Enter bar code : ");
				barCodes.add(scanner.next());
			};
			// print the output
			IntStream.range(0, numberOfProducts).forEach(intConsumer);
			ReceiptDetails receiptDetails = receiptService.calculateReceipt(barCodes);
			System.out.println(receiptDetails.toString());
			scanner.close();
			System.exit(0);

		} catch (RetailException e) {
			logger.error("Error while retrieving prodicts {}", e.getErrorCode().getDescription());
			System.exit(0);
		}

	}

}
