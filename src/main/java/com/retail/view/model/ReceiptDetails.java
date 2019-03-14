package com.retail.view.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import com.retail.exceptions.ErrorCodes;

/**
 * The class will represent the receipt details
 *
 */
public class ReceiptDetails {

	private List<ProductDetails> productDetails;
	private BigDecimal totalTax = BigDecimal.ZERO;
	private BigDecimal totalPrice = BigDecimal.ZERO;
	private boolean generationSuccessfulIndicator;
	private ErrorCodes errorCodes;

	/**
	 * @return the productDetails
	 */
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	/**
	 * @param productDetails
	 *            the productDetails to set
	 */
	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	/**
	 * @return the totalTax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax
	 *            the totalTax to set
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the generationSuccessfulIndicator
	 */
	public boolean isGenerationSuccessfulIndicator() {
		return generationSuccessfulIndicator;
	}

	/**
	 * @param generationSuccessfulIndicator
	 *            the generationSuccessfulIndicator to set
	 */
	public void setGenerationSuccessfulIndicator(boolean generationSuccessfulIndicator) {
		this.generationSuccessfulIndicator = generationSuccessfulIndicator;
	}

	/**
	 * @return the errorCodes
	 */
	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

	/**
	 * @param errorCodes
	 *            the errorCodes to set
	 */
	public void setErrorCodes(ErrorCodes errorCodes) {
		this.errorCodes = errorCodes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Receipt Details \n");
		Consumer<ProductDetails> outputProductDetails = detail -> {
			builder.append(
					String.format("%s %s", detail.getDescription(), detail.getPrice().setScale(2).toPlainString()));
		};
		this.productDetails.stream().forEach(outputProductDetails);
		builder.append(String.format("\n Total tax : %s", this.getTotalTax().setScale(2).toPlainString()));
		builder.append(String.format("\n Total Bill : %s", this.getTotalPrice().setScale(2).toPlainString()));
		return builder.toString();
	}

}
