package com.AD.SpringbootAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AD.SpringbootAPI.binding.Products;
import com.AD.SpringbootAPI.repo.Productrepository;

@Service
public class Productserviceimpl implements ProductService{

	@Autowired
	private Productrepository productrepository;
	
	@Override
	public String upsert(Products products) {
		productrepository.save(products);
		return "success";
	}

	@Override
	public Products getbyId(Integer id) {
		Optional<Products> findById =productrepository.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Products> getAllProducts() {
		
		return productrepository.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(productrepository.existsById(id)) {
			productrepository.deleteById(id);
			return "delete success";
		}
		else {
		return "no records";
		}
	}

	
}
