package com.retail.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.exceptions.ErrorCodes;
import com.retail.exceptions.RetailException;
import com.retail.model.Product;

/**
 * The service class will load all the products.
 * 
 * @author mitu
 *
 */
public final class ProductsService {

	private static final Logger logger = LoggerFactory.getLogger(ProductsService.class);

	private Map<String, Product> productData = null;

	private Properties salesTaxConfig = null;

	private static ProductsService productsService = null;

	public static ProductsService getInstance() {
		if (productsService == null) {
			productsService = new ProductsService();
		}
		return productsService;
	}

	/**
	 * Create the instance of the singleton and load all the products
	 * 
	 * @return ProductsService
	 * @throws RetailException
	 */
	public void loadProducts() throws RetailException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			productData = (Map<String, Product>) objectMapper.readValue(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("products.json"),
					new TypeReference<HashMap<String, Product>>() {
					});
			// load properties file
			salesTaxConfig = new Properties();
			salesTaxConfig.load(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("sales_tax_entries.properties"));
		} catch (IOException e) {
			logger.error("There was an exception trying to upoad product data {}", e);
			throw new RetailException(ErrorCodes.ERR_PRODUCT_DATA_LOAD_ERROR);
		}
	}

	/**
	 * Get product details against a particular bar code.
	 * 
	 * @param barCode
	 * @return
	 * @throws RetailException
	 */
	public Product getProductDetails(String barCode) throws RetailException {
		Product product = null;
		if (Objects.isNull(barCode)) {
			logger.error("Product code to be looked up cannot be null..");
			throw new RetailException(ErrorCodes.ERR_PRODUCT_INVALID_PRODUCT_CODE_ERROR);
		}
		if (Objects.nonNull(productData) && !productData.isEmpty()) {
			product = productData.get(barCode);
		}
		return product;
	}

	/**
	 * @return the salesTaxConfig
	 */
	public Properties getSalesTaxConfig() {
		return salesTaxConfig;
	}

}
