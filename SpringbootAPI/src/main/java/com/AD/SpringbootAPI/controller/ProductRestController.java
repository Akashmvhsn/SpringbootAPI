package com.AD.SpringbootAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AD.SpringbootAPI.binding.Products;
import com.AD.SpringbootAPI.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@RequestBody Products product){
		String status=productService.upsert(product);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getProducts(@PathVariable Integer id){
		Products product=productService.getbyId(id);
		return new ResponseEntity<Products>(product,HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> allProducts=productService.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct(@RequestBody Products product){
		String status=productService.upsert(product);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProducts(@PathVariable Integer id){
		String status=productService.deleteById(id);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	}

