package com.example.demo.discountAgreement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.discountAgreement.repository.DiscountAgreementRepository;

@Service
public class DiscountAgreementService {
    
    @Autowired
    DiscountAgreementRepository discountRepository;

    public void createDiscountAgreement(DiscountAgreement discountagreement){
        discountRepository.save(discountagreement);
    }
}
