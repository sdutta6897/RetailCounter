package com.retail.view.model;

import java.math.BigDecimal;

public class ProductDetails {

	private String description;
	private BigDecimal price;
	private String productCategory;
	private String productCode;
	private BigDecimal salexTaxValue;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory
	 *            the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the salexTaxValue
	 */
	public BigDecimal getSalexTaxValue() {
		return salexTaxValue;
	}

	/**
	 * @param salexTaxValue
	 *            the salexTaxValue to set
	 */
	public void setSalexTaxValue(BigDecimal salexTaxValue) {
		this.salexTaxValue = salexTaxValue;
	}

}
