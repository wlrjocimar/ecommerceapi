package br.com.ecommerceapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.models.Category;

@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryController {
	
	
	
	
	
	public ResponseEntity<List<Category>> getCategories(){
		
		
		return null;
	}

}
