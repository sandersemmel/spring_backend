package com.example.demo.product.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;

@RestController()
@RequestMapping("/product")
public class ProductRest {

	@Autowired
	ProductService productService;

	@GetMapping("/producttest")
	public String greeting() {
		return "hello from product";
	}

	@GetMapping("/createproduct")
	public String createProduct() {
		productService.createProduct();
		return "called";
	}

	@GetMapping("/getallproducts")
	public List<Product> getallproducts() {
		var products = productService.getAllProducts();
		return products;
	}

}
