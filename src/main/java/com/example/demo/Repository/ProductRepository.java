package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
     
}
