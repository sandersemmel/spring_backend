package com.example.demo.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.dto.DTO_DiscountAgreement;
import com.example.demo.product.entity.Product;
import com.github.rkpunjal.sqlsafe.SqlSafeUtil;

import org.springframework.web.bind.annotation.RequestParam;



@RestController()
@RequestMapping("/discountagreement")
public class DiscountAgreementRest {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/creatediscount")
	public String createProduct(@RequestBody DTO_DiscountAgreement dto_discountAgreement) {
		
		if( !(SqlSafeUtil.isSqlInjectionSafe(dto_discountAgreement.getAgreementType()) && SqlSafeUtil.isSqlInjectionSafe(product.getName()) )){
			return "Not created";
		}

		Product newProduct = new Product();
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
	
		productService.createProduct(product);
		return "Created";
	}
}
