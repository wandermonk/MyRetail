package com.target.myretail.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myretail.apiresponse.ResponseMessages;
import com.target.myretail.models.Product;
import com.target.myretail.models.ProductDescription;
import com.target.myretail.models.ProductWithDescription;
import com.target.myretail.services.ProductDescriptionService;
import com.target.myretail.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
@Api(value = "MyRetail Store", description = "MyRetail product catalogue.")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	private ProductService productService;

	private ProductDescriptionService productDescriptionService;

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
			logger.info(ResponseMessages.PRODUCTS_NOT_AVAILABLE);
		}
		return products;
	}

	@ApiOperation(value = "Find a product with an ID", response = Product.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Product> showProduct(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		if (product == null) {
			logger.info("Product ID :: " + id);
			logger.info(ResponseMessages.PRODUCTS_NOT_AVAILABLE);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}

	@ApiOperation(value = "Get product with description", response = Product.class)
	@RequestMapping(value = "/desc/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> showProductDescription(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		logger.info("Getting product description and details with Product ID :: " + id);
		ProductDescription productDesc = productDescriptionService.getProductById(id);
		ProductWithDescription productWithDesc = new ProductWithDescription();
		productWithDesc.setProductId(product.getproductID());
		productWithDesc.setProductDesc(productWithDesc.getProductDesc());
		productWithDesc.setCurrentPrice(product.getCurrentPrice());
		ObjectMapper om = new ObjectMapper();
		String productWithDescription = "";
		try {
			productWithDescription = om.writeValueAsString(productWithDesc);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (product == null || productDesc == null) {
			logger.info(ResponseMessages.PRODUCTS_NOT_AVAILABLE);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productWithDescription);
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		logger.info("Saved product " + product.toString());
		return new ResponseEntity<String>(ResponseMessages.SAVE_SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id);
		storedProduct.setCurrentPrice(product.getCurrentPrice());
		productService.saveProduct(storedProduct);
		logger.info("Updated product with ID :: " + id + " with product information " + product.toString());
		return new ResponseEntity<String>(ResponseMessages.UPDATE_SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		logger.info("Deleted product with ID :: " + id);
		return new ResponseEntity<String>(ResponseMessages.DELETE_SUCCESS, HttpStatus.OK);
	}

}
