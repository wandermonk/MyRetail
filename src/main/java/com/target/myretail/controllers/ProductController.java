package com.target.myretail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.myretail.apiresponse.ResponseMessages;
import com.target.myretail.models.Product;
import com.target.myretail.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
@Api(value = "MyRetail Store", description = "MyRetail product catalogue.")
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@ApiOperation(value = "Show all available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Product> list(Model model) {
		Iterable<Product> products = productService.listAllProducts();
		if (products == null) {
			System.out.println(ResponseMessages.PRODUCTS_NOT_AVAILABLE);
		}
		return products;
	}

	@ApiOperation(value = "Find a product with an ID", response = Product.class)
	public ResponseEntity<Product> showProduct(@PathVariable Integer id, Model model) {
		Product product = productService.getProductById(id);
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<String>(ResponseMessages.SAVE_SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id);
		storedProduct.setCurrentPrice(product.getCurrentPrice());
		productService.saveProduct(storedProduct);
		return new ResponseEntity<String>(ResponseMessages.UPDATE_SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>(ResponseMessages.DELETE_SUCCESS, HttpStatus.OK);

	}

}
