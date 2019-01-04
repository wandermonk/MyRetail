package com.target.myretail.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.target.myretail.models.Product;
import com.target.myretail.repositories.ProductRepository;

public class ProductServiceMockTests {

	private ProductService productService;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private Product product;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		productService = new ProductService();
		productService.setProductRepository(productRepository);
	}

	@Test
	public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
		// Arrange
		when(productRepository.findById(5)).thenReturn(Optional.of(product));
		// Act
		Product retrievedProduct = productService.getProductById(5);
		// Assert
		assertThat(retrievedProduct, is(equalTo(product)));

	}

	@Test
	public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
		// Arrange
		when(productRepository.save(product)).thenReturn(product);
		// Act
		Product savedProduct = productService.saveProduct(product);
		// Assert
		assertThat(savedProduct, is(equalTo(product)));
	}

	@Test
	public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
		// Arrange
		doNothing().when(productRepository).deleteById(5);
		ProductRepository my = Mockito.mock(ProductRepository.class);
		// Act
		productService.deleteProduct(5);
		// Assert
		verify(productRepository, times(1)).deleteById(5);
	}

}
