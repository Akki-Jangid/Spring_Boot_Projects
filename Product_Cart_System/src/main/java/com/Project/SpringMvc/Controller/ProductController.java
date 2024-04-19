package com.Project.SpringMvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Project.SpringMvc.Model.Product;
import com.Project.SpringMvc.Repository.ProductRepository;

@Controller
public class ProductController {
	
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path="/products")
	public String displayproducts(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "products";
	}
	
	@RequestMapping(path = "/products/add", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		return "create";
	}
	
	@RequestMapping(path = "/addProducts", method = RequestMethod.POST)
	public String addProduct(Product product) {
		productRepository.save(product);
		return "redirect:/";
	}
	
	@GetMapping(path = "/products/update/{id}")
	public String editProduct(@PathVariable(value = "id") int id, Model model) {
		model.addAttribute("product", productRepository.findById(id).orElse(null));
		return "create";
	}
	
	@GetMapping(path = "/products/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") int id) {
		productRepository.deleteById(id);
		return "redirect:/products";
	}
	
}
