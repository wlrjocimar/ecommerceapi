package br.com.ecommerceapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.models.Product;
import br.com.ecommerceapi.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getById(){
		
		List<Product> products = new ArrayList<>();
		products= productService.getProducts();
		
		return ResponseEntity.ok().body(products);
		
		
	}

}
