package com.target.myretail.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.target.myretail.models.Product;

@Repository
@Service
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
