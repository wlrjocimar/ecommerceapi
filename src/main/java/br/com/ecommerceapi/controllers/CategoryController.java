package br.com.ecommerceapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.models.Category;
import br.com.ecommerceapi.repositories.CategoryRepository;
import br.com.ecommerceapi.services.CategoryService;

@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories(){
		
		List<Category> categories = categoryService.getAllCategories();
		
		return ResponseEntity.ok().body(categories);
		
		
		
	}

}
