package com.AD.SpringbootAPI.service;

import java.util.List;

import com.AD.SpringbootAPI.binding.Products;

public interface ProductService {

	public String upsert(Products products);
	
	public Products getbyId(Integer id);
	
	public List<Products> getAllProducts();
	
	public String deleteById(Integer id);
}
