package com.target.myretail.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.myretail.models.CurrentPrice;
import com.target.myretail.models.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class })
public class ProductRepositoryTests {
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	public void testSaveProduct() {
		// setup product
		Product p15643793 = new Product();
		CurrentPrice cp15643793 = new CurrentPrice();
		cp15643793.setCurrencyCode("USD");
		cp15643793.setValue((float) 16.49);
		p15643793.setCurrentPrice(cp15643793);
		p15643793.setproductID(15643793);
		// save product, verify has Product ID value after save
		assertNull(p15643793.getproductID()); // null before save
		productRepository.save(p15643793);
		assertNotNull(p15643793.getproductID()); // not null after save
		// fetch from DB
		Product fetchedProduct = productRepository.findById(p15643793.getproductID()).orElse(null);
		// should not be null
		assertNotNull(fetchedProduct);
		// should equal
		assertEquals(p15643793.getproductID(), fetchedProduct.getproductID());
		assertEquals(p15643793.getCurrentPrice(), fetchedProduct.getCurrentPrice());
		// update current price and save
		CurrentPrice cp15643793_2 = new CurrentPrice();
		cp15643793.setCurrencyCode("USD");
		cp15643793.setValue((float) 173.49);
		fetchedProduct.setCurrentPrice(cp15643793_2);
		productRepository.save(fetchedProduct);
		// get from DB, should be updated
		Product fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getproductID()).orElse(null);
		// verify count of products in DB
		long productCount = productRepository.count();
		assertEquals(productCount, 1);
		// get all products, list should only have one
		Iterable<Product> products = productRepository.findAll();
		int count = 0;
		for (Product p : products) {
			count++;
		}
		assertEquals(count, 1);
	}
}
