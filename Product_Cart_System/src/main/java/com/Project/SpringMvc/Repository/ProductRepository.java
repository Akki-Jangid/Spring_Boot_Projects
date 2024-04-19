package com.Project.SpringMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.SpringMvc.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
