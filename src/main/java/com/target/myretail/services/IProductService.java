package com.target.myretail.services;

import com.target.myretail.models.Product;

public interface IProductService {

	Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);
	
	Product saveProduct(Product product);
	
	void deleteProduct(Integer id);
	
}
