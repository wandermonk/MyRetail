package com.target.myretail.resources;

import org.springframework.hateoas.ResourceSupport;

import com.target.myretail.controllers.ProductController;
import com.target.myretail.models.Product;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/*
 * ProductResource - Creates resources with HATEOAS for the headless clients.
 */
public class ProductResource extends ResourceSupport {

	private final Product product;

	public ProductResource(final Product product) {
		this.product = product;
		final Integer id = product.getproductID();
		add(linkTo(methodOn(ProductController.class).showProduct(id)).withSelfRel());
	}

}
