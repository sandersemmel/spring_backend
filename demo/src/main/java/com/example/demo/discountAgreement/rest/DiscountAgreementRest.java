package com.example.demo.discountAgreement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.discountAgreement.entity.AgreementType;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.discountAgreement.service.DiscountAgreementService;
import com.example.demo.dto.DTO_DiscountAgreement;
import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;
import com.example.demo.util.Util;
import com.github.rkpunjal.sqlsafe.SqlSafeUtil;

import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin
@RestController()
@RequestMapping("/discountagreement")
public class DiscountAgreementRest {

	@Autowired
	private DiscountAgreementService discountService;

	@Autowired
	private ProductService productService;
	
	@PostMapping("/creatediscount")
	public String createDiscount(@RequestBody DTO_DiscountAgreement dto_discountAgreement) {
		System.out.println("hit");
		try {
			if(!Util.isSafeFromSqlInject(dto_discountAgreement)){
				return "Not created";
			}
		} catch (Exception e) {
			return "Not created - unable to check for sql injection";
		}


		Product product = null;

		if(dto_discountAgreement.getAgreementType() == AgreementType.PERCENTAGE_OFF_PRODUCT || dto_discountAgreement.getAgreementType() == AgreementType.BUY_X_ONLY_PAY_Y ){
			product = productService.getProduct(dto_discountAgreement.getProductId());
			if(product == null){
				return "Not created - no product";
			}
		}

		// TODO MAPPER?
		DiscountAgreement discountAgreement = new DiscountAgreement();
		discountAgreement.setAgreementType(dto_discountAgreement.getAgreementType());
		discountAgreement.setMustBuyAmount(dto_discountAgreement.getMustBuyAmount());
		discountAgreement.setOnlyPayForAmount(dto_discountAgreement.getOnlyPayForAmount());
		discountAgreement.setPercentageOff(dto_discountAgreement.getPercentageOff());
		discountAgreement.setProduct(product);
		
		return "Created";
	}
}
