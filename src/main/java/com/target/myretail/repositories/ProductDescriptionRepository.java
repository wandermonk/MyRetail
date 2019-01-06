package com.target.myretail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.target.myretail.models.ProductDescription;

/*
 * ProductDescriptionRepository - Repository to perform CRUD operations on the Products Description store.
 */
@Repository
@Service
public interface ProductDescriptionRepository extends MongoRepository<ProductDescription, Integer> {
	public ProductDescription findByProductId(Integer productId);
}
