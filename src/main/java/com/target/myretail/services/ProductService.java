package com.target.myretail.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myretail.models.Product;
import com.target.myretail.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {

	private final Logger logger = LoggerFactory.getLogger(ProductService.class);

	ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Iterable<Product> listAllProducts() {
		logger.info("Getting list of all products in the repository.");
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		logger.info("Getting product from the repository with ID :: " + id);
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product saveProduct(Product product) {
		logger.info("Saving product to the repository with ID :: " + product.getproductID() + " with product "
				+ product.toString());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

}
