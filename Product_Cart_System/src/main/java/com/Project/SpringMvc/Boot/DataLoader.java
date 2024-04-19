package com.Project.SpringMvc.Boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Project.SpringMvc.Model.Product;
import com.Project.SpringMvc.Repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner{

	private ProductRepository productRepository;
	private Logger print = LoggerFactory.getLogger(DataLoader.class);
	
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product();
		p1.setName("Gaming PC");
		p1.setCategory("Electronics");
		p1.setBrand("Intel");
		p1.setPrice("99999");
		p1.setRating("4.8");

//		print.info(productRepository.save(p1).toString());
		
		Product p2 = new Product();
		p2.setName("Protein Powder");
		p2.setCategory("Fitness and Nutrition");
		p2.setBrand("Muscle Blaze");
		p2.setPrice("3999");
		p2.setRating("4.8");
		
//		print.info(productRepository.save(p2).toString());
	}
}
