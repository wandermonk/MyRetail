package com.target.myretail.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myretail.models.ProductDescription;
import com.target.myretail.repositories.ProductDescriptionRepository;

@Service
public class ProductDescriptionService implements IProductDescriptionService {
	private final Logger logger = LoggerFactory.getLogger(ProductDescriptionService.class);
	
	ProductDescriptionRepository productDescriptionRepository;
		
	@Autowired
	public void setProductDescriptionRepository(ProductDescriptionRepository productDescriptionRepository) {
		this.productDescriptionRepository = productDescriptionRepository;
	}

	@Override
	public ProductDescription getProductById(Integer id) {
		logger.info("Get product by ID :: "+id);
		return productDescriptionRepository.findByProductId(id);
	}

}
