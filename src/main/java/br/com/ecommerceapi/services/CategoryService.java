package br.com.ecommerceapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.models.Category;
import br.com.ecommerceapi.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		
		try {
			List<Category> categories =  categoryRepository.findAll();
			return categories;
			
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		
	}

}
