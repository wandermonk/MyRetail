package com.target.myretail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.target.myretail.models.ProductDescription;

@Repository
@Service
public interface ProductDescriptionRepository extends MongoRepository<ProductDescription, Integer> {
	public ProductDescription findByProductId(Integer productId);
}
