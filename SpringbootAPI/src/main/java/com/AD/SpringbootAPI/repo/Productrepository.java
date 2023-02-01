package com.AD.SpringbootAPI.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AD.SpringbootAPI.binding.Products;

public interface Productrepository extends JpaRepository<Products, Serializable> {

}
