package com.target.myretail.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.target.myretail.models.Product;
/*
 * ProductRepository - Repository to perform CRUD operations on the Products store.
 */
@Repository
@Service
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
