package com.retail.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.retail.exceptions.RetailException;
import com.retail.model.Product;
import com.retail.view.model.ProductDetails;
import com.retail.view.model.ReceiptDetails;

/**
 * Calculate the receipt
 *
 */
public class ReceiptService {

	/**
	 * Calculate the receipt for the product codes.
	 * 
	 * @param barCodes
	 * @return ReceiptDetails
	 */
	public ReceiptDetails calculateReceipt(List<String> barCodes) {
		ProductsService productsService = ProductsService.getInstance();
		ReceiptDetails receiptDetails = new ReceiptDetails();
		List<Product> products = null;
		if (Objects.nonNull(barCodes) && !barCodes.isEmpty()) {
			receiptDetails.setGenerationSuccessfulIndicator(true);
			products = barCodes.stream().map(barCode -> {
				try {
					Product product = productsService.getProductDetails(barCode);
					return product;
				} catch (RetailException e) {
					receiptDetails.setGenerationSuccessfulIndicator(false);
					receiptDetails.setErrorCodes(receiptDetails.getErrorCodes());
				}
				return null;
			}).collect(Collectors.toList());
			if (receiptDetails.isGenerationSuccessfulIndicator()) {
				List<ProductDetails> productDetails = products.stream().map(product -> {
					ProductDetails productDetail = new ProductDetails();
					productDetail.setDescription(product.getProductDescription());
					productDetail.setPrice(product.getProductPrice());
					String salesTaxValue = productsService.getSalesTaxConfig()
							.getProperty(product.getProductCategory());
					BigDecimal tax = product.getProductPrice()
							.multiply(new BigDecimal(salesTaxValue).divide(BigDecimal.valueOf(100)));
					productDetail.setSalexTaxValue(tax);
					return productDetail;
				}).collect(Collectors.toList());
				BigDecimal totalTax = productDetails.stream().map(ProductDetails::getSalexTaxValue)
						.reduce(BigDecimal.ZERO, BigDecimal::add);
				BigDecimal totalPrice = productDetails.stream().map(ProductDetails::getPrice).reduce(BigDecimal.ZERO,
						BigDecimal::add);
				receiptDetails.setTotalPrice(totalPrice.add(totalTax));
				receiptDetails.setTotalTax(totalTax);
				receiptDetails.setProductDetails(productDetails);
			}
		}
		return receiptDetails;
	}

}
