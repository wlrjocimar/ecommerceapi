package br.com.ecommerceapi.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerceapi.models.Product;
import br.com.ecommerceapi.repositories.ProductRepository;
import br.com.ecommerceapi.services.ProductService;

@RestController
@RequestMapping("products")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getById(){
		
		List<Product> products = new ArrayList<>();
		products= productService.getProducts();
		
		return ResponseEntity.ok().body(products);
		
		
	}
	
	
	@PostMapping
	public ResponseEntity<Product> newProduct(@RequestBody Product product){
		
		Product savedProduct = productService.newProduct(product);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProduct.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(savedProduct);
		
	}
	
	
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<HttpStatus> removeProduct(@PathVariable Integer productId){
		
		productService.removeProductById(productId);
		
		return ResponseEntity.noContent().build();
		
	}
	
	

}
